package com.wposs.alfa.modules.user.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.core.controller.BaseSpringController;
import com.wposs.core.controller.ProcessController;
import com.wposs.core.model.BaseResponse;
import com.wposs.core.spring.Input;
import com.wposs.core.spring.Output;

@RestController
@RequestMapping(path = "/users")
public class UserController extends BaseSpringController<UserServices>{

	@PostMapping("/getUser")
	@Input(name="user_app",			required="true", 			type="String",				values="")
	@Input(name="user",			    required="true", 			type="String",				values="")
	@Input(name="password",			required="true", 			type="String",				values="")
	@Input(name="device",			required="true", 			type="String",				values="")
	@Output(name="username",		required="true", 			type="String",				values="")
	@Output(name="device",   		required="true", 			type="String",				values="")
	@Output(name="message", 		required="true", 			type="String",				values="")
	public ResponseEntity<BaseResponse<Map<String, Object>>> searchUserByEmail(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return processController( new ProcessController<BaseResponse<Map<String, Object>>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<Map<String, Object>>> onProcess( BaseResponse<Map<String, Object>> response ) throws Exception {
				response.setModel( getService().getUser(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}
}

