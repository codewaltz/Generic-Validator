package com.covisint.validation;

import java.util.Map;

public interface ValidationInput<k> {

	
	public k getValidationData();
	
	public String getSchemaPath();
	
	public Map<String,Object> getValidationHeaders();
	
	public ValidationInput<k> setValidationData(k data);
	
	public ValidationInput<k> setSchemaPath(String path);
	
	public ValidationInput<k> setValidationHeaders(Map<String,Object> headers);
	
	
}
