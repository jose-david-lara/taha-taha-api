package com.tahataha.modules.params.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tahataha.modules.params.model.GetLocationInputDTO;
import com.tahataha.modules.params.model.ParametersInputDTO;
import com.tahataha.modules.params.service.ParamsServices;
import com.velorum.framework.spring.ResponseModel;
import com.velorum.framework.spring.ValidateBody;



@RestController
@RequestMapping(path = "/params")
public class ParamsController extends ParamsServices {
	
	protected ValidateBody validBody;

	@PostMapping("/getCategories")
	public ResponseEntity<ResponseModel> getParameters(@RequestBody @Valid  ParametersInputDTO paramInput, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }
	    //return null;
	    return new ResponseEntity<ResponseModel>(getCategoriesService(paramInput), HttpStatus.OK);
	   /* return new ResponseEntity<ResponseModel>(getCategoriesService(authUser), HttpStatus.OK);*/

	}
	
	@PostMapping("/getLocationsDefault")
	public ResponseEntity<ResponseModel> getLocationsDefault(@RequestBody @Valid  GetLocationInputDTO getLocaltionInput, BindingResult bindigResult ) throws Exception {
	    if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }
	    return new ResponseEntity<ResponseModel>(getLocationsDefaultService(getLocaltionInput), HttpStatus.OK);

	}	
	
	
}
