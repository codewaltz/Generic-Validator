package com.covisint.validation;

import com.covisint.validator.exception.ValidationException;

public interface ValidationReport {

	public Boolean isValid();
	public ValidationException asException();
	
}
