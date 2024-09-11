package com.ShareMarketProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CompanyDetails {
	@Id
	private int cmpId;
	private String companyName;
	private Long availableVolume;
	
	
	public CompanyDetails() {
	
	}


	public CompanyDetails(int cmpId, String companyName, Long availableVolume) {
		super();
		this.cmpId = cmpId;
		this.companyName = companyName;
		this.availableVolume = availableVolume;
	}


	public int getCmpId() {
		return cmpId;
	}


	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public Long getAvailableVolume() {
		return availableVolume;
	}


	public void setAvailableVolume(Long availableVolume) {
		this.availableVolume = availableVolume;
	}
	
	
}
