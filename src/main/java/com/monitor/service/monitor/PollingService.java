package com.monitor.service.monitor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.domain.ServiceStatus;
import com.monitor.service.NotificationService;
import com.monitor.util.TimeUtil;

public class PollingService implements Runnable {
	
	private final static Logger LOGGER = Logger.getLogger(PollingService.class);
	
	private ServiceRegistry serviceRegistry;
	
	private NotificationService notificationService;
	
	public PollingService(ServiceRegistry sr) {
		serviceRegistry = sr;
	}
	
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Override
	public void run() {
		// Get polling frequency (seconds)
		long nextPollingTime = TimeUtil.getMilliseconds(serviceRegistry.getPollFrequency());
		do {			
			// Wait the thread until it reaches the polling time
			try {
				Thread.sleep(nextPollingTime);
				
				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				LOGGER.info(Thread.currentThread().getName() + " ==> [" + time + "] ==> " + serviceRegistry);
				//System.out.println(Thread.currentThread().getName() + " ==> [" + time + "] ==> " + serviceRegistry);
				
				// Poll the service and get the status
				Service service = serviceRegistry.getService();
				ServiceStatus newStatus = pollService(service);
				
				// If the new status is DOWN and a grace period (seconds) has set, retry to poll the service
				int gracePeriodS = serviceRegistry.getGracePeriod();
				if (gracePeriodS > 0 && newStatus == ServiceStatus.DOWN) {
					nextPollingTime = TimeUtil.getMilliseconds(serviceRegistry.getPollFrequency()) +
										TimeUtil.getMilliseconds(gracePeriodS);					
					continue;
				}
				
				// If the previous status is different to the new status of the service, then notify the subscriber (caller)
				if (service.getStatus() != newStatus) {
					service.setStatus(newStatus);
					service.setLastUpdatedTime(Calendar.getInstance().getTime());
					notificationService.sendNotification(serviceRegistry);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} while(true);

	}

	private ServiceStatus pollService(Service service) throws InterruptedException {
		ServiceStatus status = ServiceStatus.DOWN;
		// 1. Check whether there is a planned service outage
		int startTimeHHmm = service.getOutageStartTime();
		int endTimeHHmm = service.getOutageEndTime();
		
		// 2. If there is a planned outage, then not poll until the service is back
		if (isServiceOutage(startTimeHHmm, endTimeHHmm)) {
			Thread.sleep(TimeUtil.getMillisecondsBetween(startTimeHHmm, endTimeHHmm));
		}
		
		// 3. If there is no planned outage, then poll the service
		try(Socket socket = new Socket()) {
			SocketAddress address = new InetSocketAddress(service.getHost(), service.getPort());
			socket.connect(address);
			boolean isConnected = socket.isConnected();
			if (isConnected) {
				status = ServiceStatus.UP;
			}			
		} catch (IOException ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		 
		return status;
	}
	 
	
	private boolean isServiceOutage(int startTime, int endTime) {
		// If start and end time are zero, then consider it as no time has set for service outage
		if (startTime == 0 && endTime == 0) {
			return false;
		}
		// If end time is zero and start time is not, then consider it as incorrect configuration. 
		// Hence consider it as no time has set for service outage 
		if (startTime != 0 && endTime == 0) {
			return false;
		}
		int currentTime = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm")));
		return (startTime <= currentTime) && (currentTime <= endTime);
	}	
}
