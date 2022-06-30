package com.tahataha.modules.user.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class AuthenticationInputDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4924521246595575967L;
	
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user_app;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String user;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String password;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String device;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String version;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String ip;
	

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "AuthenticationInput [user_app=" + user_app + ", user=" + user + ", password=" + password + ", device="
				+ device + ", version=" + version + ", ip=" + ip + "]";
	}
	
}
