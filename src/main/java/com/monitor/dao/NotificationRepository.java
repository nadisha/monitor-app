package com.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitor.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
