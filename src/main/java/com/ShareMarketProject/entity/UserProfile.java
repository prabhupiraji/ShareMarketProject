package com.ShareMarketProject.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class UserProfile {
          @Id 
	private String userName;
	private String email;
	private Long mobileNo;
	private int age;
	private String password;
	
	@ManyToMany
    @JoinTable(
        name = "user_shares",
        joinColumns = @jakarta.persistence.JoinColumn(name = "userName"),
        inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "sharesId")
    )
    private Set<Shares> shares = new HashSet<>();
	
	public UserProfile() {
		super();

	}

	
	
	public UserProfile(String userName, String email, Long mobileNo, int age, String password, Set<Shares> shares) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.age = age;
		this.password = password;
		this.shares = shares;
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



	public Set<Shares> getShares() {
		return shares;
	}



	public void setShares(Set<Shares> shares) {
		this.shares = shares;
	}
	

}
