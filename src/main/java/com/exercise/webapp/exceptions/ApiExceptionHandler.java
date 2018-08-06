package com.exercise.webapp.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * ApiExceptionHandler is a generic exception handler class to handle different types of exceptions.
 *
 * @author arao
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * This is a method that creates and returns an instance of ResponseEntity.
	 * @param error - an instance of Error
	 * @return a ResponseEntity instance
	 */
	public ResponseEntity<Object> createResponseEntity(Error error) {
	       return new ResponseEntity<>(error, error.getStatus());
	   }
	
	/**
	 * This method handles the case when a requested item is not found in the system.
	 * @param ex - An instance of ItemNotFoundException.
	 * @return an instance of ResponseEntity
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(ItemNotFoundException.class)
	protected ResponseEntity<Object> handleItemNotFound(ItemNotFoundException ex) {
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
		error.setMessage(ex.getMessage());
	       return createResponseEntity(error);
	   }
}
