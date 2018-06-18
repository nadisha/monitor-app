package com.monitor.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.dao.ServiceRepository;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceStatus;
import com.monitor.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
	
	@Autowired
	private ServiceRepository repository;
	
	@Override
	@Transactional
	public Service save(Service service) {
		service.setLastUpdatedTime(Calendar.getInstance().getTime());
		service.setStatus(ServiceStatus.INITIALIZED);
		service = repository.save(service);
		return service;
	}
	
	@Override
	public List<Service> getServices() {
		return repository.findAll();
	}
}
