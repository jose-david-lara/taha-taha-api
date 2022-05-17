package com.wposs.alfa.modules.params.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class GetLocationInputDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953044055961365046L;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user_app;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String token_access;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String locations;
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
	public void setToken_access(String token_access) {
		this.token_access = token_access;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	@Override
	public String toString() {
		return "GetLocationInput [user_app=" + user_app + ", user=" + user + ", token_access=" + token_access
				+ ", locations=" + locations + "]";
	}
	
}
