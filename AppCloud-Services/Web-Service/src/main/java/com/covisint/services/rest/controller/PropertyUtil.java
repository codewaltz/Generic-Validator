package com.covisint.services.rest.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Interfaces with application properties 
 * and system properties.
 * 
 * @author kunal.divekar@covisint.com
 *
 */

public class PropertyUtil {

	
	private static Map<String,String> propertyMap=null;
	
	public static String getProperty(String propertyName) {
	
		if(propertyMap==null){				
			Properties props = System.getProperties();
			try{
			props.load(PropertyUtil.class.getResourceAsStream("/schema-mapping.properties"));
			}catch(IOException ioExp){
				//TODO: use logger for log statement
			}
		}
		return String.valueOf(propertyMap.get(propertyName));	
	}
	
}
