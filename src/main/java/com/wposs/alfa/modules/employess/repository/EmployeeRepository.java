package com.wposs.alfa.modules.employess.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wposs.alfa.modules.employess.model.Employee;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Transaction;

public class EmployeeRepository extends BaseRepositoryDAO{


	@Autowired
	private JdbcTemplate jdbcTemplate;


	/*
	 * Ejemplo para TODO!!!
	 * 
	 */
	public  Map<String, Object> getEmployess(Transaction <?> t, Map<String, Object> request) throws Exception  {

		Map<String, Object> responseDB = new HashMap<>();
		List<Employee> employees = new ArrayList<>();
		String sql = "select serial, modelo from equipos where estado = ?";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {
				request.get("id_equipo")
		});

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				Employee employee = new Employee();
				employees.add(employee);
			}
			responseDB.put("employess", employees);
			responseDB.put("message", "consulta exitosa");
			
		}else {
			responseDB.put("message", "no existen datos");
		}

		return responseDB;
		
		
	}
}
