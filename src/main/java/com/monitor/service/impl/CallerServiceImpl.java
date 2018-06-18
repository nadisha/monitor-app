package com.monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.dao.CallerRepository;
import com.monitor.domain.Caller;
import com.monitor.service.CallerService;

@Service
public class CallerServiceImpl implements CallerService {

	@Autowired
	private CallerRepository repository;
	
	@Override
	public Caller save(Caller caller) {
		return repository.save(caller);
	}

	@Override
	public List<Caller> getCallers() {
		return repository.findAll();
	}

}
