package com.monitor.exception;

public class MonitorException extends Exception {
	private String message;
	
	public MonitorException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
