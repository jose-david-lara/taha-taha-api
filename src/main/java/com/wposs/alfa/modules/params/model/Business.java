package com.wposs.alfa.modules.params.model;

import java.io.Serializable;

public class Business implements Serializable{
	
	private String idCategorie;
	private String idBusiness;
	private String name;
	private String description;
	private String img;
	private String urlBusiness;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3802566482201659067L;

	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getIdBusiness() {
		return idBusiness;
	}

	public void setIdBusiness(String idBusiness) {
		this.idBusiness = idBusiness;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrlBusiness() {
		return urlBusiness;
	}

	public void setUrlBusiness(String urlBusiness) {
		this.urlBusiness = urlBusiness;
	}

	@Override
	public String toString() {
		return "Business [idCategorie=" + idCategorie + ", idBusiness=" + idBusiness + ", name=" + name
				+ ", description=" + description + ", img=" + img + ", urlBusiness=" + urlBusiness + "]";
	}
	
}
