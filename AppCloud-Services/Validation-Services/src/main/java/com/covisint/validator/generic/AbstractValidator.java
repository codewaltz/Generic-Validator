package com.covisint.validator.generic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.covisint.util.JsonUtil;
import com.covisint.validation.ValidationInput;
import com.covisint.validator.exception.SchemaValidationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

/**
 * This is a abstract data validator. All concrete 
 * validators intending to use json schema validation
 * should extend this class.
 * 
 * @author kunal.divekar@covisint.com
 *
 */

public abstract class AbstractValidator<k> implements Validator<Boolean, ValidationInput<k>> {

		
	protected List<String> mandatoryHeaders;
	
	/**
	 ** This method validates inputs against existing json schema. 
	 * It selects appropriate schema based on the inputs and then 
	 * uses the json schema validation library to validate the 
	 * given input. Please note that this validation is optimized 
	 * for correctness and performance in that order. 
	 *  
	 * @param body The json that needs validations
	 * @param schemaPath path of the schema against 
	 * which validation is to be performed. The schema 
	 * has to be present classpath. and the path should
	 * start with '/'
	 * 
	 * @return
	 * @throws SchemaValidationException
	 */
	protected final Boolean validateRequestBody(String body, String schemaPath) 
			throws IOException, ProcessingException{
		
		Boolean isValid = Boolean.FALSE;
		if(body==null || schemaPath==null){
			return isValid;
		}
		JsonNode schemaNode = JsonLoader.fromResource(schemaPath);	
		JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
	    JsonValidator jsonValidator = factory.getValidator();
	    JsonNode bodyNode = JsonUtil.readTree(body);
	    isValid = jsonValidator.validate(schemaNode, bodyNode).isSuccess();
		
		return isValid;
	}
	
	protected abstract Boolean headerValidation(Map<String,Object> headers);
	
	public final void setMandatoryHeaders(List<String> headers){
		this.mandatoryHeaders = headers;
	}

}
