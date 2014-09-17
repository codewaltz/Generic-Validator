package com.covisint.validator.generic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.covisint.validator.exception.ValidationException;

/**
 * Test class for {@link BaseSchemaValidatorTest}
 * 
 * @author kunal.divekar@covisint.com
 *
 */

public class BaseSchemaValidatorTest {

	
	private BaseValidator validator;
	@Before
	public void setUp(){
		
		validator = new BaseValidator();
	}
	@After
	public void destroy(){
		validator = null;
	}
	
	@Test
	public void testValidate() throws ValidationException{
	
		Assert.assertTrue(validator.validate("{\"firstName\": \"abc\",\"lastName\": \"defgh\",\"age\": 5}", "/schema/sample.json"));
		
	}

}
