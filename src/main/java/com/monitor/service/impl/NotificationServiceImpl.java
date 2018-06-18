package com.monitor.service.impl;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.dao.NotificationRepository;
import com.monitor.dao.ServiceRepository;
import com.monitor.domain.Notification;
import com.monitor.domain.NotifyType;
import com.monitor.domain.Service;
import com.monitor.domain.ServiceRegistry;
import com.monitor.service.NotificationService;

@org.springframework.stereotype.Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private NotificationRepository repository;
	
	/*
	 * Send notifications through all the channels
	 */
	@Override	
	public void sendNotification(ServiceRegistry serviceRegistry) {
		sendNotification(NotifyType.EMAIL, serviceRegistry);
		sendNotification(NotifyType.SMS, serviceRegistry);
		updateService(serviceRegistry.getService());
	}
	
	@Async
	@Override
	public void sendNotification(NotifyType type, ServiceRegistry serviceRegistry) {
		switch (type) {
			case EMAIL:
				// TODO: Send email notification
				break;
			case SMS:
				// TODO: Send SMS notification
				break;
			default:
				// No notification is sent
				break;
		}
		saveNotificationLog(serviceRegistry, type, String.format("Service is %s", serviceRegistry.getService().getStatus()));
	}
	
	@Transactional
	@Async	
	@Override	
	public void updateService(Service service) {
		serviceRepository.save(service);
	}	
	
	@Override
	public List<Notification> getAll() {
		Sort sort = new Sort(Direction.DESC, "notifyDate");
		return repository.findAll(sort);
	}
	
	@Transactional
	private void saveNotificationLog(ServiceRegistry sr, NotifyType type, String message) {
		Notification log = new Notification();
		log.setCallerName(sr.getCaller().getName());
		log.setServiceName(sr.getService().getName());
		log.setNotifyType(type);
		log.setMessage(message);
		log.setNotifyDate(Calendar.getInstance().getTime());
		repository.save(log);
	}
}
