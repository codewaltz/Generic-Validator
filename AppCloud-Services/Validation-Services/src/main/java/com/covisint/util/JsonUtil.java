package com.covisint.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper;
	
	static{
		mapper = new ObjectMapper();		
	}		
	
	public static JsonNode readTree(String input) throws JsonProcessingException, IOException{
		
		JsonNode node = null;
		try {
			node = mapper.readTree(input);				
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		return node;
	}
	
	
}
