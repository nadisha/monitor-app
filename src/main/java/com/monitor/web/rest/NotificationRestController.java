package com.monitor.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.domain.Notification;
import com.monitor.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestController {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping
	public List<Notification> loadNotifications() {
		return service.getAll();
	}
}
