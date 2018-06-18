package com.monitor.service;

import java.util.List;

import com.monitor.domain.Caller;

public interface CallerService {
	
	public Caller save(Caller caller);
	
	public List<Caller> getCallers();
}
