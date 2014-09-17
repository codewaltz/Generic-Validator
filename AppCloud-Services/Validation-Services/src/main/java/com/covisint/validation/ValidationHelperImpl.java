package com.covisint.validation;

import java.io.IOException;
import java.util.Iterator;

import com.covisint.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

public class ValidationHelperImpl implements ValidationHelper<ValidationInput<String>> {

	
	@Override
	public ValidationReport validate(ValidationInput<String> input) {
		
		String data = input.getValidationData();
		String schemaPath = input.getSchemaPath();
		SimpleValidationReport report = new SimpleValidationReport();
		try{
			JsonNode schemaNode = JsonLoader.fromResource(schemaPath);	
			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
			JsonValidator jsonValidator = factory.getValidator();
			JsonNode bodyNode = JsonUtil.readTree(data);
			ProcessingReport prReport = jsonValidator.validate(schemaNode, bodyNode);
			Iterator<ProcessingMessage> msgIterator = prReport.iterator();
			while(msgIterator.hasNext()){
				ProcessingMessage msg = msgIterator.next();
				
				if(!(msg.getLogLevel().compareTo(LogLevel.ERROR)<0)){
					
				}
			}
		}catch(IOException ioExp){
			report.setError("Error reading the schema from given path");
		}catch(ProcessingException prExp){
			report.setError("Something went wrong, Error performing validation");
		}		
		return report;
	}

}
