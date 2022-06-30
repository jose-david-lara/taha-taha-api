package com.tahataha.modules.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tahataha.modules.user.dto.AuthenticationInputDTO;
import com.tahataha.modules.user.dto.UserInputDTO;
import com.tahataha.modules.user.services.UserServices;
import com.velorum.framework.spring.ResponseModel;
import com.velorum.framework.spring.ValidateBody;

@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{
	
	protected ValidateBody validBody;

	@PostMapping("/getAuthentication")
	public ResponseEntity<ResponseModel> authenticationUser(@RequestBody @Valid  AuthenticationInputDTO authUser, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }	
		return new ResponseEntity<ResponseModel>(getAuthenticationService(authUser), HttpStatus.OK);
	
	}
	
	@PostMapping("/getCreateUser")
	public ResponseEntity<ResponseModel> createUser(@RequestBody @Valid  UserInputDTO inputUser, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }	
		return new ResponseEntity<ResponseModel>(getcreateUserService(inputUser), HttpStatus.OK);
	
	}
}

