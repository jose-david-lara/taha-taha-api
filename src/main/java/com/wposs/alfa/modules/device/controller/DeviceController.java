package com.wposs.alfa.modules.device.controller;

import java.util.List;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.device.model.Device;
import com.wposs.alfa.modules.device.service.DeviceServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;


@RestController
@RequestMapping(path = "/device")
public class DeviceController {
	
	@PostMapping("/getDevices")
	@Input(name="id_equipo",	    required="true", 			type="String",				values="")
	@Output(name="device",			required="true", 			type="String",				values="")
	@Output(name="message",			required="true", 			type="String",				values="")
	public ResponseEntity<String> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return null;
	}	

}
