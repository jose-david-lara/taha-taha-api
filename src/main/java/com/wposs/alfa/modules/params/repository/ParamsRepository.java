package com.wposs.alfa.modules.params.repository;

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

import com.wposs.alfa.modules.params.model.Business;
import com.wposs.alfa.modules.params.model.Categories;
import com.wposs.alfa.modules.params.model.GetLocationInput;
import com.wposs.alfa.modules.params.model.ParametersInput;
import com.wposs.alfa_framework.spring.RepositoryDAO;

@Component
public class ParamsRepository extends RepositoryDAO{


    
       

	public List<Categories> getCategoriesRepository( ParametersInput paramsInput) throws Exception  {

		List<Categories> categories = new ArrayList<>();
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
				Categories categorie = new Categories();
				categorie.setIdCategorie(((Number)row.get("ID_CATEGORIE_BUSINESS")).toString());
				categorie.setName((String) row.get("NAME"));
				categorie.setDescription((String) row.get("DESCRIPTION"));
				categorie.setImg((String) row.get("URL_IMG"));
				categories.add(categorie);
			}
		}		
		return categories;
	}
		

	public List<Business> getBusinessRepository( ) throws Exception  {
		
		List<Business> business = new ArrayList<>();
		String sql = "SELECT  "
				+ "ID_BUSINESS,NAME, DESCRIPTION,IMG, URL,ID_CATEGORIE "
				+ "FROM DANKO.DANKO_BUSINESS ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				Business bussn = new Business();
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
	
	public  Map<String, Object> getValidTokenAccess( ParametersInput paramsInput) throws Exception  {

	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_VALID_TOKEN_ACCESS(?, ?, ?, ?,)}");
	        cs.setString(1, paramsInput.getToken_access());
	        cs.setString(2, paramsInput.getUser());
	        cs.setString(3, paramsInput.getUser_app());
	        cs.registerOutParameter(4, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	     
	}
	
	public  Map<String, Object> getLocaltionDefaultRepository( GetLocationInput getLocaltionInput) throws Exception  {

	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_VALID_TOKEN_ACCESS(?, ?, ?, ?,)}");
	       /* cs.setString(1, paramsInput.getToken_access());
	        cs.setString(2, paramsInput.getUser());
	        cs.setString(3, paramsInput.getUser_app());*/
	        cs.registerOutParameter(4, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	     
	}


}
