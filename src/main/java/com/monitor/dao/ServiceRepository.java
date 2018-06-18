package com.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitor.domain.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
