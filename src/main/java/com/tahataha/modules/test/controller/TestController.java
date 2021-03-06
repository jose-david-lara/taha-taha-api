package com.tahataha.modules.test.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tahataha.modules.test.dto.TestInput;
import com.tahataha.modules.test.service.TestServices;
import com.velorum.framework.spring.ResponseModel;
import com.velorum.framework.spring.ValidateBody;

@RestController
@RequestMapping(path = "/test")
public class TestController extends TestServices{
	
	protected ValidateBody validBody;
	
	@PostMapping("/getTest")
	public ResponseEntity<ResponseModel> getTEST( @RequestBody @Valid  TestInput inputTest, BindingResult bindingResult) throws Exception{
	    if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }	
		return new ResponseEntity<ResponseModel>(getTESTServices(inputTest), HttpStatus.OK);

	}

}
