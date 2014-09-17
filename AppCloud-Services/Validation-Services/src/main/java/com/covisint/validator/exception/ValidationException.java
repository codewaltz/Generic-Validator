package com.covisint.validator.exception;

/**
 * Exception class to be utilized to handle 
 * data validation exception.
 * 
 * @author kunal.divekar@covisint.com
 *
 */
public class ValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	protected String errorMessage;

	public ValidationException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	
}
