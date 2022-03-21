package com.wposs.alfa.modules.employess.service;

import java.util.Map;

import com.wposs.alfa.modules.employess.repository.EmployeeRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

public class EmployeeServices extends BaseSpringService<EmployeeRepository>{
	
	public Map<String, Object> getEmployees(Map<String, Object> request) throws Exception {
		return beginReadTransaction(new Transaction<Map<String, Object>>() {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().getEmployess(this, request);
			}
			
		});
				
	}
}
