package com.exercise.webapp.exceptions;

import org.springframework.http.HttpStatus;

/**
 * 
 * Error is a generic class that is created to handle invalid requests.
 *
 * @author arao
 */
public class Error {

	private HttpStatus status;
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}

	Error(HttpStatus status) {
		this.status = status;
	}
	
	Error(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		this.message = message;
	}	
}
