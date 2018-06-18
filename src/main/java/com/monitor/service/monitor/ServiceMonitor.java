package com.monitor.service.monitor;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.domain.ServiceRegistry;
import com.monitor.service.NotificationService;
import com.monitor.service.ServiceRegistryService;
import com.monitor.util.CommonUtil;

@Service
public class ServiceMonitor {
	@Autowired
	private ServiceRegistryService serviceRegistry;	
	
	@Autowired
	private NotificationService notificationService;
	
	@PostConstruct
	public void init() {
		initializeMonitor();
	}
	
	private void initializeMonitor() {
		// Get all the service subscription records
		List<ServiceRegistry> serviceRegistries = serviceRegistry.getAll();
						
		// Create thread for each service vs subscriber
		for (ServiceRegistry sr : serviceRegistries) {
			executeTask(sr);
		}		
	}
	
	private void executeTask(ServiceRegistry serviceRegistry) {
		PollingService pollingService = new PollingService(serviceRegistry);
		pollingService.setNotificationService(notificationService);				
		String threadName = String.format(CommonUtil.THREAD_NAME, serviceRegistry.getService().getName(), serviceRegistry.getCaller().getName());
		Thread newThread = new Thread(pollingService, threadName);
		newThread.start();		
	}
}
