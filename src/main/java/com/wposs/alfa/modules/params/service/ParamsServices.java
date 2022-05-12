package com.wposs.alfa.modules.params.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.model.Business;
import com.wposs.alfa.modules.params.model.Categories;
import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class ParamsServices {
	
	private static String SUCCESS_MSG = "SUCCESS_MSG";
	private static String FAIL_MSG = "FAIL_MSG";
	
	public ResponseModel getCategoriesService(Map<String, Object> request) throws Exception {

				Map<String, Object> response = new HashMap<>();
				List<Categories> categoriesList = new ArrayList<>();
				
				List<Categories> categories = null;// getRepository().getCategories(this, request);
				
				List<Business> business = null;// getRepository().getBusiness(this, request);	
				
				
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
				if(categories.isEmpty()) {
					response.put("message", FAIL_MSG);
				}
				return null;
			
				
	}
	
	public Map<String, Object> getLocationsDefault(Map<String, Object> request) throws Exception {
		return null;
				
	}	

}

