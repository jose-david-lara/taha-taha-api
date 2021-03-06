package com.tahataha.modules.params.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class ParametersInputDTO implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2046767883911254556L;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user_app;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String token_access;
	
	public String getUser_app() {
		return user_app;
	}
	public void setUser_app(String user_app) {
		this.user_app = user_app;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getToken_access() {
		return token_access;
	}
	public void setToken_access(String token_acces) {
		this.token_access = token_acces;
	}
	@Override
	public String toString() {
		return "ParametersInput [user_app=" + user_app + ", user=" + user + ", token_access=" + token_access + "]";
	}
	
	

}
