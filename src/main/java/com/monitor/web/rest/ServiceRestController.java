package com.monitor.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.service.ServiceRegistryService;
import com.monitor.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceRestController {
	
	@Autowired
	private ServiceService service;
	
	@Autowired
	private ServiceRegistryService serviceRegistryService;
	
	@PostMapping	
	public Service createService(@RequestBody Service s) {
		return service.save(s);
	}
	
	@GetMapping
	public List<Service> getServices() {
		List<Service> services = service.getServices();
		List<ServiceRegistry> registries = serviceRegistryService.getAll();
		
		services = services.stream().map(s -> {
			// Get list of service names for a caller
			List<String> callerNames = registries.stream()
													.filter(r -> r.getService().getId() == s.getId())
													.map(r -> r.getCaller().getName())													
													.collect(Collectors.toList());
			String callers = String.join(", ", callerNames);
			s.setSubscribeCallerNames(callers);
			return s;
		}).collect(Collectors.toList());		
		return services;
	}
}
