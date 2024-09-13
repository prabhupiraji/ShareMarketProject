package com.ShareMarketProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.entity.UserProfile;
import com.ShareMarketProject.repo.UserRepo;

@Service
public class UserService {
	
     @Autowired
	UserRepo userRepo;
	
	public UserProfile createUserProfile(UserProfile profile) {
		 UserProfile savedProfile = userRepo.save(profile);
		return savedProfile;
	}

	public UserProfile updateUserProfile(UserProfile profile, String email) {
		// TODO Auto-generated method stub
		UserProfile updatedProfile = userRepo.save(profile);
		return updatedProfile;
	}

	public Optional<UserProfile> findById(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findById(userName);
	}
	 
	

}
