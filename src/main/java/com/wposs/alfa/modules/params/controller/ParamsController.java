package com.wposs.alfa.modules.params.controller;

import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.params.service.ParamsServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;


@RestController
@RequestMapping(path = "/params")
public class ParamsController {

	@PostMapping("/getCategories")
	@Input(name="user_app",			required="true", 			type="String",				values="")
	@Input(name="user",			    required="true", 			type="String",				values="")
	@Output(name="parameters",  	required="true", 			type="String",				values="")
	@Output(name="message",     	required="true", 			type="String",				values="")
	public ResponseEntity<String> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return null;

	}
	
	@PostMapping("/getLocationsDefault")
	@Input(name="user_app",			required="true", 			type="String",				values="")
	@Input(name="user",			    required="true", 			type="String",				values="")
	@Output(name="locations",    	required="true", 			type="String",				values="")
	@Output(name="message",     	required="true", 			type="String",				values="")
	public ResponseEntity<String> getLocationsDefault(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return null;

	}	
}
