package com.wposs.alfa.modules.params.model;

import java.io.Serializable;

public class CityDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5343835399095802952L;
	
	private String idCity;
	private String idCountry;
	private String name;
	private String description;
	private String latitud;
	private String longitud;
	private String image;
	private String type;
	
	
	public String getIdCity() {
		return idCity;
	}
	public String getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CityDTO [idCity=" + idCity + ", idCountry=" + idCountry + ", name=" + name + ", description="
				+ description + ", latitud=" + latitud + ", longitud=" + longitud + ", image=" + image + ", type="
				+ type + "]";
	}
	
}
