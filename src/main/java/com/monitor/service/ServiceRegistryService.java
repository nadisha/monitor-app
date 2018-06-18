package com.monitor.service;

import java.util.List;

import com.monitor.domain.Caller;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.exception.AlreadyExistException;

public interface ServiceRegistryService {
	
	public ServiceRegistry save(ServiceRegistry serviceRegistry) throws AlreadyExistException;
	
	public List<ServiceRegistry> getAll();
	
	public ServiceRegistry getByServiceAndCaller(Service service, Caller caller);
	
	public ServiceRegistry stop(String serviceName, String callerName);
}
