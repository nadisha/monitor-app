package com.monitor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_registries")
public class ServiceRegistry implements Serializable{
	
	private static final long serialVersionUID = 4579740523462191280L;
	
	@Id
	private ServiceRegistryPK serviceRegistryPK = new ServiceRegistryPK();
	
	@ManyToOne
	@JoinColumn(name = "service_id",  nullable = false, updatable = false, insertable = false)	
	private Service service;

	@ManyToOne
	@JoinColumn(name = "caller_id",  nullable = false, updatable = false, insertable = false)		
	private Caller caller;
	
	private int pollFrequency;
	
	private int gracePeriod;
	
	@Enumerated(EnumType.STRING)
	private MonitorStatus status;

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		if (service != null) {
			this.serviceRegistryPK.setService(service.getId());
		}
		this.service = service;
	}
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
		if (caller != null) {
			this.serviceRegistryPK.setCaller(caller.getId());
		}
		this.caller = caller;
	}
	public int getPollFrequency() {
		return pollFrequency;
	}
	public void setPollFrequency(int pollFrequency) {
		this.pollFrequency = pollFrequency;
	}
	public int getGracePeriod() {
		return gracePeriod;
	}
	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}
	public MonitorStatus getStatus() {
		return status;
	}
	public void setStatus(MonitorStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServiceRegistry [service=" + service + ", caller=" + caller + ", pollFrequency=" + pollFrequency
				+ ", gracePeriod=" + gracePeriod + ", status=" + status + "]";
	}
}

@Embeddable
class ServiceRegistryPK implements Serializable {

	private static final long serialVersionUID = 7525352616541949115L;

	@SuppressWarnings("unused")
	@Column(name = "service_id", nullable = false, updatable = false, insertable = false)	
	private Long service;
	
	@SuppressWarnings("unused")
	@Column(name = "caller_id", nullable = false, updatable = false, insertable = false)	
	private Long caller;

	public Long getService() {
		return service;
	}

	public void setService(Long service) {
		this.service = service;
	}

	public Long getCaller() {
		return caller;
	}

	public void setCaller(Long caller) {
		this.caller = caller;
	}
}
