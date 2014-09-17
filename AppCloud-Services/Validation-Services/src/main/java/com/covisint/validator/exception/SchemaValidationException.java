package com.covisint.validator.exception;

/**
 * This exception class is to be used when there 
 * are errors validating data against a specific 
 * schema
 * 
 * 
 * @author kunal.divekar@covisint.com
 *
 */

public class SchemaValidationException extends ValidationException {
	
	private static final long serialVersionUID = 1L;
	private String schemaName;
	private String inspectedData;
	
	public SchemaValidationException(String errorMessage, String schemaName,
			String inspectedData) {
		super(errorMessage);
		this.schemaName = schemaName;
		this.inspectedData = inspectedData;
	}

}
