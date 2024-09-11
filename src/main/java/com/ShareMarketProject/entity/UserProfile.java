package com.ShareMarketProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserProfile {
          @Id 
	private String userName;
	private String email;
	private Long mobileNo;
	private int age;
	private String password;
	
	public UserProfile() {
		super();

	}

	public UserProfile(String userName, String email, Long mobileNo, int age, String password) {
	
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.age = age;
		this.password=password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
