package com.tahataha.modules.test.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tahataha.modules.test.dto.TestInput;
import com.velorum.framework.spring.Confisys;
import com.velorum.framework.spring.RepositoryDAO;



@Component
public class TestRepository extends RepositoryDAO{


	public  Map<String, Object> getTESTRepository( TestInput inputTest) throws Exception  {
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "SELECT  "
				+ "'TEST' AS TEST "
				+ "FROM DUAL ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				System.out.println("RESPUESTA DB::"+(String) row.get("TEST"));
				respuesta.put("test", (String) row.get("TEST"));
				
			}
		}
		
		return  respuesta;
	}
	
	public Map<String, Object> getTestConfisys(List<String> confisys) throws Exception {
		Confisys conf = new Confisys();
		Map<String, Object> respuesta = new HashMap<>();
		
		respuesta = conf.confisysQuerys(confisys, jdbcTemplate);
		System.out.println(":::RESPUESTA:::"+respuesta);
		
		return respuesta;

	}
}
