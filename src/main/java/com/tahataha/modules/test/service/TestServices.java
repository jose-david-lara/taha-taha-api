package com.tahataha.modules.test.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tahataha.modules.test.dto.TestInput;
import com.tahataha.modules.test.repository.TestRepository;
import com.velorum.framework.spring.CodeResponseRequest;
import com.velorum.framework.spring.ResponseModel;

@Component
public class TestServices extends TestRepository{
	
	public final static Logger LOGGER = LoggerFactory.getLogger(TestServices.class);


	public ResponseModel getTESTServices(TestInput inputTest) throws Exception {
		ResponseModel rspModel = new ResponseModel();
		List<String> confisysList = new ArrayList<>();
		confisysList.add("SALT_DANKO");
		try {
			
			LOGGER.info(":::REQUEST getTESTServices:::"+inputTest.toString(), TestServices.class.getName());
			
			rspModel.setCode("0");
			rspModel.setMessage("exitoso");
			rspModel.setError(false);
			rspModel.setData(null);
			//rspModel.setData(getTESTRepository(inputTest));
			//rspModel.setData(getTestConfisys(confisysList));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("::::ERROR BACKEND:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}

		
		LOGGER.info(":::RESPONSE getTESTServices:::"+rspModel.toString(), TestServices.class.getName());
		
		return rspModel;

	}
}
