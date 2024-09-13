package com.ShareMarketProject.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Positive;

@Entity
public class Shares {
	@Id
	private int sharesId;
	@Positive(message="quanity must be greater then zero")
	private int quantity;
	private double price;
	private double totalPrice;
//	private CompanyDetails companyDetails;
	 @ManyToMany(mappedBy = "shares")
	    private Set<UserProfile> shares = new HashSet<>();
	
	public Shares() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Shares(int sharesId, @Positive(message = "quanity must be greater then zero") int quantity, double price,
			double totalPrice, Set<UserProfile> shares) {
		super();
		this.sharesId = sharesId;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.shares = shares;
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


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Set<UserProfile> getUsers() {
		return shares;
	}


	public void setUsers(Set<UserProfile> users) {
		this.shares = shares;
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
