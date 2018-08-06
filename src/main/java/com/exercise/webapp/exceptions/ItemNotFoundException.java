package com.exercise.webapp.exceptions;

@SuppressWarnings("serial")
/**
 * 
 * ItemNotFoundException is a specific instance of an exception that gets created when a requested item is not found in the system.
 *
 * @author arao
 */
public class ItemNotFoundException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public ItemNotFoundException(String message) {
		this.message = message;
	}
	
	public String generateMessage(String message) {
		return message;
	}
}