package com.covisint.validation;

import java.util.Map;

import com.covisint.util.ValidationEnum;
import com.covisint.validator.exception.ValidationException;
import com.google.common.collect.Maps;

public class SimpleValidationReport implements ValidationReport {

	private Map<String,String> errorMessages = Maps.newLinkedHashMap();
	private Boolean isValid;
	
	@Override
	public Boolean isValid() {
		
		return isValid==null?Boolean.FALSE:isValid;
	}

	@Override
	public ValidationException asException() {		
		String errorMsg = errorMessages.get(ValidationEnum.ERROR_MSG.getValue());
		return new ValidationException(errorMsg);
	}

	protected void setError(String errMsg){
		errorMessages.put(ValidationEnum.ERROR_MSG.getValue(), errMsg);
	}
	
}
