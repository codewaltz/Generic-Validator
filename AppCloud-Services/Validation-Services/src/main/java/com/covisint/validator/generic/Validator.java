package com.covisint.validator.generic;

import com.covisint.validation.ValidationInput;
import com.covisint.validator.exception.ValidationException;

/**
 * All validators for service requests have to 
 * implement this validation interface.
 * 
 * @author kunal.divekar@covisint.com
 *
 */
public interface Validator<k,v> {
	
	/**
	 * This method should perform the required validation
	 * on the validation data <K> using validation condition <V>
	 * @return
	 */
	public k validate(v input) throws ValidationException;

}
