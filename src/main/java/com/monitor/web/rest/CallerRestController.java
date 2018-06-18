package com.monitor.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.domain.Caller;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.service.CallerService;
import com.monitor.service.ServiceRegistryService;

@RestController
@RequestMapping("/api/callers")
public class CallerRestController {
	
	@Autowired
	private CallerService service;
	
	@Autowired
	private ServiceRegistryService serviceRegistryService;
	
	@PostMapping
	public Caller createCaller(@RequestBody Caller caller) {
		return service.save(caller);
	}
	
	@GetMapping
	public List<Caller> getCallers() {
		List<Caller> callers = service.getCallers();
		List<ServiceRegistry> registries = serviceRegistryService.getAll();
		
		callers = callers.stream().map(c -> {
			// Get list of service names for a caller
			List<String> serviceNames = registries.stream()
													.filter(r -> r.getCaller().getId() == c.getId())
													.map(r -> r.getService().getName())													
													.collect(Collectors.toList());
			String services = String.join(", ", serviceNames);
			c.setServiceSubscriptionNames(services);
			return c;
		}).collect(Collectors.toList());
		return callers;
	}
}
