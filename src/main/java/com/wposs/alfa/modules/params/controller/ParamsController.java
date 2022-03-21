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
import com.wposs.core.controller.BaseSpringController;
import com.wposs.core.controller.ProcessController;
import com.wposs.core.model.BaseResponse;
import com.wposs.core.spring.Input;
import com.wposs.core.spring.Output;

@RestController
@RequestMapping(path = "/params")
public class ParamsController extends BaseSpringController<ParamsServices>{

	@PostMapping("/getParameters")
	@Input(name="user_app",			required="true", 			type="String",				values="")
	@Input(name="user",			    required="true", 			type="String",				values="")
	@Output(name="parameters",  	required="true", 			type="String",				values="")
	public ResponseEntity<BaseResponse<Map<String, Object>>> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return processController( new ProcessController<BaseResponse<Map<String, Object>>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<Map<String, Object>>> onProcess( BaseResponse<Map<String, Object>> response ) throws Exception {
				response.setModel( getService().getParameters(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}
}
