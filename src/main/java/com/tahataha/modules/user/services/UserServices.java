package com.tahataha.modules.user.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tahataha.modules.user.dto.AuthenticationInputDTO;
import com.tahataha.modules.user.dto.UserInputDTO;
import com.tahataha.modules.user.repository.UserRepository;
import com.velorum.framework.security.SecurityService;
import com.velorum.framework.spring.CodeResponseRequest;
import com.velorum.framework.spring.ResponseModel;

@Component
public class UserServices extends  UserRepository{
	
	public final static Logger LOGGER = LoggerFactory.getLogger(UserServices.class);


	public ResponseModel getAuthenticationService(AuthenticationInputDTO authUser) throws Exception {

		ResponseModel rspModel = new ResponseModel();

		try {
			Map <String, Object> mapResponse = new HashMap<String, Object>();
			Map <String, Object> mapProcess = new HashMap<String, Object>();
			
			LOGGER.info(":::REQUEST getAuthenticationService:::"+authUser.toString(), UserServices.class.getName());
			

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
					rspModel.setCode("0");
					rspModel.setMessage("exitoso");
					rspModel.setError(false);
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
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}


		return rspModel;
	}
	
	public ResponseModel getcreateUserService(UserInputDTO userInput) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		
		try {
			
			userInput.setJwt_feed(userInput.getName());
			
			rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
			rspModel.setMessage(CodeResponseRequest.SUCCESS_MSG);
			rspModel.setError(false);
			rspModel.setData(getCreateUserRepository( (new Gson().toJson(userInput))));
			
			
		
		}catch (Exception e) {
			System.out.println("ERROR:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}
		return rspModel;
	}

}

