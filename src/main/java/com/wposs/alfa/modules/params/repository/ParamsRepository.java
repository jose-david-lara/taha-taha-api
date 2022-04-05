package com.wposs.alfa.modules.params.repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.model.Business;
import com.wposs.alfa.modules.params.model.Categories;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Transaction;

@Component
public class ParamsRepository extends BaseRepositoryDAO{


	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
       

	public List<Categories> getCategories(Transaction <?> t, Map<String, Object> request) throws Exception  {

		List<Categories> categories = new ArrayList<>();
		String sql = "SELECT  "
				+ "DCBUSINESS.ID_CATEGORIE_BUSINESS, DCBUSINESS.NAME, DCBUSINESS.DESCRIPTION, DCBUSINESS.URL_IMG "
				+ "FROM DANKO.DANKO_CATEGORIES_BUSINESS DCBUSINESS, "
				+ "DANKO.DANKO_USER DUSER "
				+ "WHERE DCBUSINESS.DANKO_STATE = ? "
				+ "AND DUSER.EMAIL = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				1,
				request.get("user").toString());

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
		

	public List<Business> getBusiness(Transaction <?> t, Map<String, Object> request) throws Exception  {
		
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
	


}
