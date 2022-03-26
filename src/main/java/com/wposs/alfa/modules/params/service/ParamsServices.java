package com.wposs.alfa.modules.params.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.model.Business;
import com.wposs.alfa.modules.params.model.Categories;
import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class ParamsServices extends BaseSpringService<ParamsRepository>{
	
	public Map<String, Object> getParameters(Map<String, Object> request) throws Exception {
		return beginReadTransaction(new Transaction<Map<String, Object>>() {
			public Map<String, Object> doTransaction() throws Exception{
				
				Map<String, Object> response = new HashMap<>();
				List<Categories> categoriesList = new ArrayList<>();
				
				List<Categories> categories = getRepository().getCategories(this, request);
				
				List<Business> business = getRepository().getBusiness(this, request);	
				
				
				for(Categories categorie : categories) {
					List<Business> businessLocal = new ArrayList<>();
					for(Business bussn : business) {
						if(bussn.getIdCategorie().equals(categorie.getIdCategorie())) {
							businessLocal.add(bussn); 							
						}
					}
					categorie.setBusiness(business);
					categoriesList.add(categorie);
				}
				response.put("parameters", categoriesList);
				return response;
			}
			
		});
				
	}

}
