package com.wposs.alfa.modules.params.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.model.BusinessDTO;
import com.wposs.alfa.modules.params.model.CategorieDTO;
import com.wposs.alfa.modules.params.model.CityDTO;
import com.wposs.alfa.modules.params.model.CountryDTO;
import com.wposs.alfa.modules.params.model.GetLocationInputDTO;
import com.wposs.alfa.modules.params.model.ParametersInputDTO;
import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.alfa_framework.spring.CodeResponseRequest;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class ParamsServices extends ParamsRepository{

	public ResponseModel getCategoriesService(ParametersInputDTO paramsInput) throws Exception {

		ResponseModel rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<>();
		List<CategorieDTO> categoriesList = new ArrayList<>();
		String respValidToken = "";


		try {
			respValidToken = getValidTokenAccess(paramsInput.getToken_access(), paramsInput.getUser(),paramsInput.getUser_app()).get("message").toString();

			if("OK".equals(respValidToken)) {

				List<CategorieDTO> categories = getCategoriesRepository(paramsInput);
				List<BusinessDTO> business = getBusinessRepository();

				if(categories == null || categories.isEmpty()) {
					rspModel.setCode(CodeResponseRequest.COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen categorias");
					rspModel.setError(true);
					return rspModel;
				}else if(business == null || business.isEmpty()) {
					rspModel.setCode(CodeResponseRequest.COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen empresas");
					rspModel.setError(true);
					return rspModel;				
				}

				for(CategorieDTO categorie : categories) {
					categorie.setBusiness(new ArrayList<BusinessDTO>());
					List<BusinessDTO> businessLocal = new ArrayList<>();
					for(BusinessDTO bussn : business) {
						if(bussn.getIdCategorie().equals(categorie.getIdCategorie())) {
							businessLocal.add(bussn); 							
						}
					}
					categorie.setBusiness(businessLocal);
					categoriesList.add(categorie);
				}

				response.put("parameters", categoriesList);

				rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
				rspModel.setMessage(CodeResponseRequest.SUCCESS_MSG);
				rspModel.setError(false);
				rspModel.setData(response);

			}else {
				rspModel.setCode("430");
				rspModel.setMessage(respValidToken);
				rspModel.setError(true);
			}

		}catch (Exception e) {
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}
		return rspModel;

	}

	public ResponseModel getLocationsDefaultService(GetLocationInputDTO getLocaltionInput) throws Exception {
		ResponseModel rspModel = new ResponseModel();
		List<CountryDTO> countries = new ArrayList<>();
		String respValidToken = "";


		try {
			System.out.println(":::PASO 1::::");
			respValidToken = getValidTokenAccess(getLocaltionInput.getToken_access(), getLocaltionInput.getUser(),getLocaltionInput.getUser_app()).get("message").toString();
			System.out.println(":::PASO 2::::");
			if("OK".equals(respValidToken)) {
				
				
				List<CountryDTO> countryList =  getLocaltionCountryRepository(getLocaltionInput);
				List<CityDTO> cityList = getLocaltionCityRepository(getLocaltionInput);

				
				System.out.println(":::LOCALTIONS COUNTRY::"+countryList.toString());
				System.out.println(":::LOCALTIONS CITY::"+cityList.toString());

				System.out.println(":::PASO 2.1::::");
				
				if(countryList == null || countryList.isEmpty()) {
					rspModel.setCode(CodeResponseRequest.COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen paises");
					rspModel.setError(true);
					return rspModel;
				}else if(cityList == null || cityList.isEmpty()) {
					rspModel.setCode(CodeResponseRequest.COD_ERROR_GENERIC_MESSAGE);
					rspModel.setMessage("No existen ciudades");
					rspModel.setError(true);
					return rspModel;				
				}
				
				
				for(CountryDTO country : countryList) {
					country.setCities(new ArrayList<CityDTO>());
					List<CityDTO> citiesLocal = new ArrayList<>();
					for(CityDTO city : cityList) {
						if(city.getIdCountry().equals(country.getIdCountry())) {
							citiesLocal.add(city); 							
						}
					}
					country.setCities(citiesLocal);
					countries.add(country);
				}
				
				//System.out.println(":::EJEMPLOS:::"+new HashMap<>().put("locations",countries).toString());
				
				rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
				rspModel.setMessage(CodeResponseRequest.SUCCESS_MSG);
				rspModel.setError(false);
				rspModel.setData(countries);

				//List<Business> business = getBusinessRepository();
			}else {
				rspModel.setCode("430");
				rspModel.setMessage(respValidToken);
				rspModel.setError(true);
			}
		}catch (Exception e) {
			System.out.println(":::ERROR BKND:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}


		return rspModel;

	}	

}

