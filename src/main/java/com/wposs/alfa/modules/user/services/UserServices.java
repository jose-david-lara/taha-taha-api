package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.dto.AuthenticationInput;
import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.alfa_framework.security.SecurityService;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class UserServices extends  UserRepository{


	public ResponseModel getAuthenticationService(AuthenticationInput authUser) throws Exception {

		ResponseModel rspModel = new ResponseModel();

		try {
			Map <String, Object> mapResponse = new HashMap<String, Object>();
			Map <String, Object> mapProcess = new HashMap<String, Object>();

			if("USER".equals(authUser.getUser_app()) || "GUEST".equals(authUser.getUser_app())) {
				mapResponse = getAuthenticationsRepository(authUser);


				if("USER".equals(authUser.getUser_app()) && (mapResponse.get("jwt_feed") != null)) {
					mapProcess =  SecurityService.encriptDesencriptBuffer(SecurityService.generateTokenJWTFeed(mapResponse.get("jwt_feed").toString()), confisysDataRepository("SALT_DANKO").get("SALT_DANKO").toString());
					
					rspModel.setCode("0");
					rspModel.setMessage("exitoso");
					rspModel.setError(false);
				}else if("USER".equals(authUser.getUser_app()) && (mapResponse.get("jwt_feed") == null)) {
					rspModel.setCode("0");
					rspModel.setMessage(mapResponse.get("message").toString());
					rspModel.setError(true);
					rspModel.setData(null);
					return rspModel;
				}else if("GUEST".equals(authUser.getUser_app())) {
					mapProcess =  SecurityService.encriptDesencriptBuffer(SecurityService.generateTokenJWTFeed(authUser.getUser_app()), confisysDataRepository("SALT_DANKO").get("SALT_DANKO").toString());
				}

				mapResponse.remove("jwt_feed");
				mapResponse.put("access", (mapProcess.get("encript") != null)?mapProcess.get("encript").toString():null);
				
				if(mapResponse.get("access") != null) {
					insertAccessTokenRepository(mapResponse.get("access").toString(),authUser.getUser());
				}
								


				rspModel.setData(mapResponse);
			}else {
				mapResponse.clear();
				rspModel.setCode("700");
				rspModel.setMessage("no autorizado");
				rspModel.setError(true);
			}
		}catch (Exception e) {
			System.out.println("ERROR:::"+e.getMessage());
			rspModel.setCode("900");
			rspModel.setMessage("error BKND");
			rspModel.setError(true);
		}


		return rspModel;
	}

}

