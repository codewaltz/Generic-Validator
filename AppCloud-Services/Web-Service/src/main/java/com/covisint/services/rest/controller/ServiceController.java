package com.covisint.services.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covisint.validator.exception.ValidationException;
import com.covisint.validator.generic.BaseValidator;



@Controller
@RequestMapping(value="/service")
public class ServiceController {

	@Autowired
	private BaseValidator validator;
	
	@ResponseBody
	@RequestMapping(value="/value", method=RequestMethod.POST, consumes="text/plain")
	public String handleValidation(@RequestBody String body) throws ValidationException{		
		System.out.println("Inside controller");
		String schemaPath = PropertyUtil.getProperty("");
		validator.validate(body, schemaPath);
		String test = "This is mvc test";
		validator.validate(body, "sample");
		return test;
	}
}
