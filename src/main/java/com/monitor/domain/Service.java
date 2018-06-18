package com.monitor.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "services")
public class Service implements Serializable {

	private static final long serialVersionUID = -8470734754396060807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String host;
	private int port;

	@Enumerated(EnumType.STRING)
	private ServiceStatus status;
	private Date lastUpdatedTime;
	private int outageStartTime;
	private int outageEndTime;

	@Transient
	private String subscribeCallerNames;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ServiceStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public int getOutageStartTime() {
		return outageStartTime;
	}

	public void setOutageStartTime(int outageStartTime) {
		this.outageStartTime = outageStartTime;
	}

	public int getOutageEndTime() {
		return outageEndTime;
	}

	public void setOutageEndTime(int outageEndTime) {
		this.outageEndTime = outageEndTime;
	}
	
	public String getSubscribeCallerNames() {
		return subscribeCallerNames;
	}

	public void setSubscribeCallerNames(String subscribeCallerNames) {
		this.subscribeCallerNames = subscribeCallerNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + port;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (port != other.port)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", host=" + host + ", port=" + port + ", status=" + status
				+ ", lastUpdatedTime=" + lastUpdatedTime + ", outageStartTime=" + outageStartTime + ", outageEndTime="
				+ outageEndTime + "]";
	}
		
}
