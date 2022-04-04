package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class UserServices extends BaseSpringService<UserRepository>{

	public Map<String, Object> getAuthentications(Map<String, Object> request) throws Exception {
		return beginReadTransaction( new Transaction<Map<String, Object>> () {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().getAuthentications( this, request );	
			}
		});
	}

}
