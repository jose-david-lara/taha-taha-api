package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	private String lastname;
	private String numberID;
	private String email;
	private String country;
	private String state;
	private String city;
	private String adress;
	private String birthday;
	private String urlPhoto;
	private String user;
	private String password;

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", numberID=" + numberID + ", email=" + email
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", adress=" + adress + ", birthday="
				+ birthday + ", urlPhoto=" + urlPhoto + ", user=" + user + ", password=" + password + "]";
	}

}
