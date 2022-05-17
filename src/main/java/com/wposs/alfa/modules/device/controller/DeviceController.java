package com.wposs.alfa.modules.device.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/device")
public class DeviceController {
	
	@PostMapping("/getDevices")
	public ResponseEntity<String> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return null;
	}	

}
