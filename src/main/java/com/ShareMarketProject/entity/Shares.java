package com.ShareMarketProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shares {
	@Id
	private int sharesId;
	private int quantity;
	private double price;
//	private CompanyDetails companyDetails;
	
	
	public Shares() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Shares(int sharesId, int quantity, double price, CompanyDetails companyDetails) {
		super();
		this.sharesId = sharesId;
		this.quantity = quantity;
		this.price = price;
//		this.companyDetails = companyDetails;
	}


	public int getSharesId() {
		return sharesId;
	}


	public void setSharesId(int sharesId) {
		this.sharesId = sharesId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


//	public CompanyDetails getCompanyDetails() {
//		return companyDetails;
//	}
//
//
//	public void setCompanyDetails(CompanyDetails companyDetails) {
//		this.companyDetails = companyDetails;
//	}
	
}
