package com.tahataha.modules.user.dto;

import java.io.Serializable;

public class UserInputDTO implements Serializable{
	
	private String name;
	private String last_name;
	private String numberID;
	private String email;
	private String country;
	private String state;
	private String city;
	private String adress;
	private String birthday;
	private String url_photo;
	private String user;
	private String password;
	private String device;
	private String jwt_feed;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371035913143907523L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNumberID() {
		return numberID;
	}

	public void setNumberID(String numberID) {
		this.numberID = numberID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUrl_photo() {
		return url_photo;
	}

	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
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

	public String getJwt_feed() {
		return jwt_feed;
	}

	public void setJwt_feed(String jwt_feed) {
		this.jwt_feed = jwt_feed;
	}

	@Override
	public String toString() {
		return "UserInputDTO [name=" + name + ", last_name=" + last_name + ", numberID=" + numberID + ", email=" + email
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", adress=" + adress + ", birthday="
				+ birthday + ", url_photo=" + url_photo + ", user=" + user + ", password=" + password + ", device="
				+ device + ", jwt_feed=" + jwt_feed + "]";
	}

}
