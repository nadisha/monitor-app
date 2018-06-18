package com.monitor.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(MonitorException.class)
	public @ResponseBody Error handleExceptions(HttpServletRequest request, MonitorException exception) {
		Error error = new Error(exception.getMessage());
		exception.printStackTrace();
		return error;
	}
}
