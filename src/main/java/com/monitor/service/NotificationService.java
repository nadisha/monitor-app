package com.monitor.service;

import java.util.List;

import com.monitor.domain.Notification;
import com.monitor.domain.NotifyType;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;

public interface NotificationService {
	public void updateService(Service service);	
	
	public void sendNotification(ServiceRegistry serviceRegistry);
	
	public void sendNotification(NotifyType type, ServiceRegistry serviceRegistry);	
	
	public List<Notification> getAll();
}
