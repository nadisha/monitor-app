package com.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitor.domain.Caller;

public interface CallerRepository extends JpaRepository<Caller, Long> {

}
