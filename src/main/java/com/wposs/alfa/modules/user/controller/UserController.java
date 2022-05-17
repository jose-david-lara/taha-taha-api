package com.wposs.alfa.modules.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.user.dto.AuthenticationInput;
import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;

@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{
	
	protected ValidateBody validBody;

	@PostMapping("/getAuthentication")
	public ResponseEntity<ResponseModel> authenticationUser(@RequestBody @Valid  AuthenticationInput authUser, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }	
		return new ResponseEntity<ResponseModel>(getAuthenticationService(authUser), HttpStatus.OK);
		

	
	}
}

