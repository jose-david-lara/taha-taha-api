package com.tahataha.modules.user.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.tahataha.modules.user.dto.AuthenticationInputDTO;
import com.velorum.framework.spring.Confisys;
import com.velorum.framework.spring.RepositoryDAO;


@Component
public class UserRepository extends RepositoryDAO{


	public  Map<String, Object> confisysDataRepository(String BufferString) throws Exception {
		List<String> listLocal = new ArrayList<String>();
		listLocal.add(BufferString);
		Confisys conf = new Confisys();
		return conf.confisysQuerys(listLocal,jdbcTemplate);/*new HashMap<String, Object>();
		String sql = "SELECT  "
				+ "DANKOCONFISYS.VALUE AS CONFVALUE "
				+ "FROM ALFA.ALFA_CONFISYS DANKOCONFISYS "
				+ "WHERE DANKOCONFISYS.NAME_CONFISYS = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				BufferString);
		
		if(rows != null) {
			for (Map<String, Object> row : rows) {
				mapResponse.put(BufferString, (String) row.get("CONFVALUE")) ;
			}
		}		
		return mapResponse;*/
	}
	
	public Map<String, Object> getTestConfisys(List<String> confisys) throws Exception {
		Confisys conf = new Confisys();
		Map<String, Object> respuesta = new HashMap<>();
		
		respuesta = conf.confisysQuerys(confisys, jdbcTemplate);
		System.out.println(":::RESPUESTA:::"+respuesta);
		
		return respuesta;

	}

	
	public  Map<String, Object> insertAccessTokenRepository(String tokenAccess, String userGuest) throws Exception {
		
	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_SECURITY_ACCESS(?,?,?)}");
	        cs.setString(1, tokenAccess);
	        cs.setString(2, userGuest);
	        cs.registerOutParameter(3, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	}
	
	public  Map<String, Object> getAuthenticationsRepository( AuthenticationInputDTO authUser) throws Exception  {

	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("username", Types.VARCHAR));
	    paramList.add(new SqlOutParameter("device", Types.VARCHAR));
	    paramList.add(new SqlOutParameter("jwt_feed", Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_AUTHENTICATION(?,?,?,?,?,?,?,?,?,?)}");
	        cs.setString(1, authUser.getUser_app());
	        cs.setString(2, authUser.getUser());
	        cs.setString(3, authUser.getPassword());
	        cs.setString(4, authUser.getDevice());
	        cs.setString(5, authUser.getVersion());
	        cs.setString(6, authUser.getIp());	        
	        cs.registerOutParameter(7, Types.VARCHAR);
	        cs.registerOutParameter(8, Types.VARCHAR);
	        cs.registerOutParameter(9, Types.VARCHAR);
	        cs.registerOutParameter(10, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	     
	}
	
	public  Map<String, Object> getCreateUserRepository( String authUser) throws Exception  {

	    List<SqlParameter> paramList = new ArrayList<SqlParameter>();
	    paramList.add(new SqlParameter(Types.VARCHAR));
	    paramList.add(new SqlOutParameter("message", Types.VARCHAR));
	    
	    return jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_CREATE_USER(?,?)}");
	        cs.setString(1, authUser);
	        cs.registerOutParameter(2, Types.VARCHAR);
	        return cs;
	      }
	    }, paramList);
	     
	}

}
