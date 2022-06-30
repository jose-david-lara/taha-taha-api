package com.tahataha.modules.params.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.tahataha.modules.params.model.BusinessDTO;
import com.tahataha.modules.params.model.CategorieDTO;
import com.tahataha.modules.params.model.CityDTO;
import com.tahataha.modules.params.model.CountryDTO;
import com.tahataha.modules.params.model.GetLocationInputDTO;
import com.tahataha.modules.params.model.ParametersInputDTO;
import com.velorum.framework.spring.RepositoryDAO;

@Component
public class ParamsRepository extends RepositoryDAO{


    
       

	public List<CategorieDTO> getCategoriesRepository( ParametersInputDTO paramsInput) throws Exception  {

		List<CategorieDTO> categories = new ArrayList<>();
		String sql = "SELECT  "
				+ "DCBUSINESS.ID_CATEGORIE_BUSINESS, DCBUSINESS.NAME, DCBUSINESS.DESCRIPTION, DCBUSINESS.URL_IMG "
				+ "FROM DANKO.DANKO_CATEGORIES_BUSINESS DCBUSINESS, "
				+ "DANKO.DANKO_USER DUSER "
				+ "WHERE DCBUSINESS.DANKO_STATE = ? "
				+ "AND DUSER.EMAIL = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				1,
				paramsInput.getUser());

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				CategorieDTO categorie = new CategorieDTO();
				categorie.setIdCategorie(((Number)row.get("ID_CATEGORIE_BUSINESS")).toString());
				categorie.setName((String) row.get("NAME"));
				categorie.setDescription((String) row.get("DESCRIPTION"));
				categorie.setImg((String) row.get("URL_IMG"));
				categories.add(categorie);
			}
		}		
		return categories;
	}
		

	public List<BusinessDTO> getBusinessRepository( ) throws Exception  {
		
		List<BusinessDTO> business = new ArrayList<>();
		String sql = "SELECT  "
				+ "ID_BUSINESS,NAME, DESCRIPTION,IMG, URL,ID_CATEGORIE "
				+ "FROM DANKO.DANKO_BUSINESS ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				BusinessDTO bussn = new BusinessDTO();
				bussn.setIdCategorie(((Number) row.get("ID_BUSINESS")).toString());
				bussn.setName((String) row.get("NAME"));
				bussn.setDescription((String) row.get("DESCRIPTION"));
				bussn.setImg((String) row.get("IMG"));
				bussn.setUrlBusiness((String) row.get("URL"));
				bussn.setIdCategorie(((Number) row.get("ID_CATEGORIE")).toString());
				business.add(bussn);
			}
		}
		
		return business;
	}
	
	public  Map<String, Object> getValidTokenAccess( String tokenAccess, String user, String userApp) throws Exception  {

	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_VALID_TOKEN_ACCESS(?, ?, ?, ?)}");
	        cs.setString(1, tokenAccess);
	        cs.setString(2, user);
	        cs.setString(3, userApp);
	        cs.registerOutParameter(4, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	     
	}
	
	public  List<CountryDTO> getLocaltionCountryRepository( GetLocationInputDTO getLocaltionInput) throws Exception  {

	    /*List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("country_list", Types.REF_CURSOR));
	    paramList.add(new SqlOutParameter("city_list", Types.REF_CURSOR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_GET_LOCATION_DEFAULT(?, ?, ?, ?, ?, ?)}");
	        cs.setString(1, getLocaltionInput.getToken_access());
	        cs.setString(2, getLocaltionInput.getUser());
	        cs.setString(3, getLocaltionInput.getUser_app());
	        cs.registerOutParameter(4, Types.REF_CURSOR);
	        cs.registerOutParameter(5, Types.REF_CURSOR);
	        cs.registerOutParameter(6, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);*/
		List<CountryDTO> countries = new ArrayList<>();
		String sql = "SELECT  "
				+ "DC_COUNTRY.COUNTRY_ID, DC_COUNTRY.COUNTRY_NAME, DC_COUNTRY.COUNTRY_DESCRIPTION, DC_COUNTRY.COUNTRY_IMAGE "
				+ "FROM DANKO.DANKO_COUNTRY DC_COUNTRY "
				+ "WHERE DC_COUNTRY.COUNTRY_STATUS = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				"S");

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				CountryDTO country = new CountryDTO();
				country.setIdCountry(((Number)row.get("COUNTRY_ID")).toString());
				country.setName((String) row.get("COUNTRY_NAME"));
				country.setDescription((String) row.get("COUNTRY_DESCRIPTION"));
				countries.add(country);
			}
		}		
		return countries;
	     
	}
	
	
	public  List<CityDTO> getLocaltionCityRepository( GetLocationInputDTO getLocaltionInput) throws Exception  {

	    /*List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("country_list", Types.REF_CURSOR));
	    paramList.add(new SqlOutParameter("city_list", Types.REF_CURSOR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_GET_LOCATION_DEFAULT(?, ?, ?, ?, ?, ?)}");
	        cs.setString(1, getLocaltionInput.getToken_access());
	        cs.setString(2, getLocaltionInput.getUser());
	        cs.setString(3, getLocaltionInput.getUser_app());
	        cs.registerOutParameter(4, Types.REF_CURSOR);
	        cs.registerOutParameter(5, Types.REF_CURSOR);
	        cs.registerOutParameter(6, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);*/
		List<CityDTO> cities = new ArrayList<>();
		String sql = "SELECT  "
				+ "DC_CITY.CITY_ID, DC_CITY.CITY_NAME, DC_CITY.CITY_DESCRIPTION, DC_CITY.CITY_IMAGE, DC_CITY.CITY_FK_COUNTRY, DC_CITY.CITY_TYPE "
				+ "FROM DANKO.DANKO_CITY DC_CITY "
				+ "WHERE DC_CITY.CITY_STATUS = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				"S");

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				CityDTO city = new CityDTO();
				city.setIdCity(((Number)row.get("CITY_ID")).toString());
				city.setName(((String)row.get("CITY_NAME")));
				city.setDescription(((String)row.get("CITY_DESCRIPTION")));
				city.setImage(((String)row.get("CITY_IMAGE")));
				city.setIdCountry(((Number)row.get("CITY_FK_COUNTRY")).toString());
				city.setType(((String)row.get("CITY_TYPE")));
				cities.add(city);
			}
		}		
		return cities;
	     
	}
	

	


}
