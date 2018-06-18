package com.monitor.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.dao.ServiceRegistryRepository;
import com.monitor.domain.Caller;
import com.monitor.domain.MonitorStatus;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.exception.AlreadyExistException;
import com.monitor.service.NotificationService;
import com.monitor.service.ServiceRegistryService;
import com.monitor.service.monitor.PollingService;
import com.monitor.util.CommonUtil;

@org.springframework.stereotype.Service
public class ServiceRegistryServiceImpl implements ServiceRegistryService {
	
	private final static Logger LOGGER = Logger.getLogger(PollingService.class);
	
	@Autowired
	private ServiceRegistryRepository repository;	
	
	@Autowired
	private NotificationService notificationService;	
	
	@Override
	@Transactional
	public ServiceRegistry save(ServiceRegistry serviceRegistry) throws AlreadyExistException{
		ServiceRegistry oldRegistry = getByServiceAndCaller(serviceRegistry.getService(), serviceRegistry.getCaller());
		if (oldRegistry != null) {
			String msg = String.format("User [%s] has already subscribed to service [%s]", serviceRegistry.getCaller().getName(),
					serviceRegistry.getService().getName());
			throw new AlreadyExistException(msg);
		}
		
		serviceRegistry.setStatus(MonitorStatus.RUNNING);
		serviceRegistry = repository.save(serviceRegistry);

		// Start a new thread
		executeTask(serviceRegistry);		
		return serviceRegistry;
	}

	@Override
	public List<ServiceRegistry> getAll() {
		return repository.findAll();
	}
	
	@Override
	public ServiceRegistry getByServiceAndCaller(Service service, Caller caller) {
		return repository.findByServiceAndCaller(service, caller);
	}
	
	@Transactional
	@Override	
	public ServiceRegistry stop(String serviceName, String callerName) {
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		String threadName = String.format(CommonUtil.THREAD_NAME, serviceName, callerName);
		Optional<Thread> thread = threads.stream().filter(t -> t.getName().equals(threadName)).findFirst();
		if (thread.isPresent()){
			thread.get().interrupt();
		}
		ServiceRegistry serviceRegistory = repository.findByServiceNameAndCallerName(serviceName, callerName);
		serviceRegistory.setStatus(MonitorStatus.STOP);
		return serviceRegistory;
	}
	
	private void executeTask(ServiceRegistry serviceRegistry) {		
		PollingService pollingService = new PollingService(serviceRegistry);
		pollingService.setNotificationService(notificationService);
		String threadName = String.format(CommonUtil.THREAD_NAME, serviceRegistry.getService().getName(), serviceRegistry.getCaller().getName());
		Thread newThread = new Thread(pollingService, threadName);
		newThread.start();
	}	
}
