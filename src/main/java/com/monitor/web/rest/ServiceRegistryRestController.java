package com.monitor.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.domain.ServiceRegistry;
import com.monitor.exception.MonitorException;
import com.monitor.service.ServiceRegistryService;

@RestController
@RequestMapping("/api/service-registries")
public class ServiceRegistryRestController {
	
	@Autowired
	private ServiceRegistryService service;
	
	@PostMapping
	public ServiceRegistry create(@RequestBody ServiceRegistry serviceRegistry) throws MonitorException{		
		return service.save(serviceRegistry);
	}
	
	@GetMapping
	public List<ServiceRegistry> getSubscriptions() {
		return service.getAll();
	}
	
	@GetMapping(value = "/${serviceName}/${callerName}/stop")
	public ServiceRegistry stop(@PathVariable String serviceName, @PathVariable String callerName) {
		return service.stop(serviceName, callerName);
	}
}
