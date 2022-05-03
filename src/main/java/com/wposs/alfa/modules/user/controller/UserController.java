package com.wposs.alfa.modules.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@PostMapping("/getUser")
	
	@Input(name="user_app",			required="true", 			type="String",				values="")
	@Input(name="user",			    required="true", 			type="String",				values="")
	@Input(name="password",			required="true", 			type="String",				values="")
	@Input(name="device",			required="true", 			type="String",				values="")
	@Input(name="version",			required="true", 			type="String",				values="")
	@Input(name="ip",    			required="true", 			type="String",				values="")	
	@Output(name="username",		required="true", 			type="String",				values="")
	@Output(name="device",   		required="true", 			type="String",				values="")
	@Output(name="message", 		required="true", 			type="String",				values="")
	public String searchUserByEmail(@Valid @RequestBody  Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		System.out.println("JSON ENTRADA:"+request.toString());
		
		
	    if (bindigResult.hasErrors()) {			
	        return  "error";
	    }
		return "";
		

	
	}
}

