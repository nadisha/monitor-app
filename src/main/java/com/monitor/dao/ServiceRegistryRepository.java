package com.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitor.domain.Caller;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;

public interface ServiceRegistryRepository extends JpaRepository<ServiceRegistry, Long> {
	public ServiceRegistry findByServiceAndCaller(Service service, Caller caller);
	
	public ServiceRegistry findByServiceNameAndCallerName(String serviceName, String callerName);
}
