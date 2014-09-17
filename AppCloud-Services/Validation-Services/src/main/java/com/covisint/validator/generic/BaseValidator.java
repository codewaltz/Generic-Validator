package com.covisint.validator.generic;

import java.io.IOException;
import java.util.Map;

import com.covisint.validation.SimpleValidationReport;
import com.covisint.validation.ValidationInput;
import com.covisint.validator.exception.ValidationException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;


public class BaseValidator extends AbstractValidator<String> {

		
	@Override
	public Boolean validate(ValidationInput<String> input)
			throws ValidationException {
		String data = input.getValidationData();
		String schemaPath = input.getSchemaPath();
		try{
			SimpleValidationReport report = new SimpleValidationReport();			
			return headerValidation(input.getValidationHeaders()) && validateRequestBody(data, schemaPath);
			
			
		}catch (IOException ioexp){
		}catch (ProcessingException prExp){
				
			}		
		
		return Boolean.FALSE;
	}

	@Override
	protected Boolean headerValidation(Map<String, Object> headers) {		
		if(mandatoryHeaders==null || mandatoryHeaders.size()==0){
		return Boolean.TRUE;
		}
		return Boolean.TRUE;
	}

}
