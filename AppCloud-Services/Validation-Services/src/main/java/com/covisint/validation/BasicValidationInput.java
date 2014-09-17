package com.covisint.validation;

import java.util.Map;

import com.covisint.util.ValidationEnum;
import com.google.common.collect.Maps;

public class BasicValidationInput implements ValidationInput<String> {

	
	private Map<String,Object> map = Maps.newLinkedHashMap();	
	
	
	@Override
	public String getValidationData() {
		return (String)this.map.get(ValidationEnum.BODY.getValue());		
	}

	@Override
	public String getSchemaPath() {
		return (String) this.map.get(ValidationEnum.SCHEMA_PATH.getValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getValidationHeaders() {		
		return (Map<String,Object>)this.map.get(ValidationEnum.VALIDATION_HEADERS.getValue()) ;
	}

	@Override
	public ValidationInput<String> setValidationData(String data) {
		this.map.put(ValidationEnum.BODY.getValue(), data);
		return this;		
	}

	@Override
	public ValidationInput<String> setSchemaPath(String path) {
		this.map.put(ValidationEnum.SCHEMA_PATH.getValue(), path);
		return this;
		
	}

	@Override
	public ValidationInput<String> setValidationHeaders(Map<String,Object> headers) {
		this.map.put(ValidationEnum.VALIDATION_HEADERS.getValue(), headers);
		return this;		
	}
}
