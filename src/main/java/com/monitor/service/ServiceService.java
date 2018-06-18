package com.monitor.service;

import java.util.List;

import com.monitor.domain.Service;

public interface ServiceService {
	
	public Service save(Service service);
	
	public List<Service> getServices();
}
