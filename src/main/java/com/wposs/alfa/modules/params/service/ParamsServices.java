package com.wposs.alfa.modules.params.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.model.Business;
import com.wposs.alfa.modules.params.model.Categories;
import com.wposs.alfa.modules.params.model.GetLocationInput;
import com.wposs.alfa.modules.params.model.ParametersInput;
import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class ParamsServices extends ParamsRepository{

	private static String SUCCESS_MSG = "EXITO";
	private static String ERROR_BK_MESSAGE = "ERROR BKND";
	private static String COD_MSG_SUCCESS = "0";
	private static String COD_ERROR_BK_MESSAGE = "900";
	private static String COD_ERROR_GENERIC_MESSAGE = "510";

	public ResponseModel getCategoriesService(ParametersInput paramsInput) throws Exception {

		ResponseModel rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<>();
		List<Categories> categoriesList = new ArrayList<>();
		String respValidToken = "";


		try {
			respValidToken = getValidTokenAccess(paramsInput).get("message").toString();

			if("OK".equals(respValidToken)) {
				
				List<Categories> categories = getCategoriesRepository(paramsInput);
				List<Business> business = getBusinessRepository();

				if(categories == null || categories.isEmpty()) {
					rspModel.setCode(COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen categorias");
					rspModel.setError(true);
					return rspModel;
				}else if(business == null || business.isEmpty()) {
					rspModel.setCode(COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen empresas");
					rspModel.setError(true);
					return rspModel;				
				}

				for(Categories categorie : categories) {
					categorie.setBusiness(new ArrayList<Business>());
					List<Business> businessLocal = new ArrayList<>();
					for(Business bussn : business) {
						if(bussn.getIdCategorie().equals(categorie.getIdCategorie())) {
							businessLocal.add(bussn); 							
						}
					}
					categorie.setBusiness(businessLocal);
					categoriesList.add(categorie);
				}

				response.put("parameters", categoriesList);

				rspModel.setCode(COD_MSG_SUCCESS);
				rspModel.setMessage(SUCCESS_MSG);
				rspModel.setError(false);
				rspModel.setData(response);

			}else {
				rspModel.setCode("430");
				rspModel.setMessage(respValidToken);
				rspModel.setError(true);
			}

		}catch (Exception e) {
			rspModel.setCode(COD_ERROR_BK_MESSAGE);
			rspModel.setMessage(ERROR_BK_MESSAGE);
			rspModel.setError(true);
		}
		return rspModel;

	}

	public ResponseModel getLocationsDefaultService(GetLocationInput getLocaltionInput) throws Exception {
		ResponseModel rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<>();
		List<Categories> countryList = new ArrayList<>();
		String respValidToken = "";
		

		 getLocaltionDefaultRepository(getLocaltionInput);
		
		System.out.println(":::PASO 2::::");

		List<Business> business = getBusinessRepository();
		
		
		return null;

	}	

}

