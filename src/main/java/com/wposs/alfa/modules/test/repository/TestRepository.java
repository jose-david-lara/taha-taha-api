package com.wposs.alfa.modules.test.repository;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Component;



@Component
public class TestRepository {



	public  Map<String, Object> getTEST( Map<String, Object> request) throws Exception  {
		int idEquipo = 1;
		Map<String, Object> response = new HashMap<>();
		
		response.put("TEST", request.get("test"));

		return response;
	}
}
