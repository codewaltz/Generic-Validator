package com.covisint.util;


public enum ValidationEnum {

	
	BODY("body"),
	INVALID_ENUM("invalid-enum"),
	SCHEMA_PATH("schemaPath"),
	VALIDATION_HEADERS("validationHeader"),
	ERROR_MSG("errorMsg");
	
	private String value;
	
	private ValidationEnum(String value){
		this.value = value;
	}
	
	public String getEnumValue(String key){
		
		for(ValidationEnum value : ValidationEnum.values()){			
			if(value.toString().equalsIgnoreCase(key)){
				return value.toString();
			}
		}
	return INVALID_ENUM.value;	
		
	}
	
	public String getValue(){		
		return this.value;
	}
}
