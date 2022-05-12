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
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;


@RestController
@RequestMapping(path = "/params")
public class ParamsController extends ParamsServices {
	
	protected ValidateBody validBody;

	@PostMapping("/getCategories")
	public ResponseEntity<ResponseModel> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }
	    return null;
	   /* return new ResponseEntity<ResponseModel>(getCategoriesService(authUser), HttpStatus.OK);*/

	}
	
	@PostMapping("/getLocationsDefault")

	public ResponseEntity<String> getLocationsDefault(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return null;

	}	
	
	
}
