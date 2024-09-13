package com.ShareMarketProject.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShareMarketProject.Exception.ErrorResponse;
import com.ShareMarketProject.dto.LoginDto;
import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.entity.UserProfile;
import com.ShareMarketProject.repo.UserRepo;
import com.ShareMarketProject.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;

	@Autowired
	UserService service;

	@PostMapping("/user/profile")
    public ResponseEntity<?> createUserProfile(@RequestBody UserProfile profile){
		if (userRepo.existsById(profile.getEmail())) {
            return new ResponseEntity<>(new ErrorResponse("User profile already exists."), HttpStatus.CONFLICT);
        }
        UserProfile createdUserProfile = service.createUserProfile(profile);
        return new ResponseEntity<>(createdUserProfile, HttpStatus.CREATED);
 
   }
	@PostMapping("/update/profile/{email}")
	public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile profile,@PathVariable String email){
    	UserProfile updateUserProfile=null;
    	if(userRepo.findById(email).isPresent()) {
    		updateUserProfile = service.updateUserProfile(profile,email);
   	}
		return new ResponseEntity<UserProfile> (updateUserProfile,HttpStatus.OK) ;
    	
    }
	@PostMapping("/user/profile/login")
   public String userLogin(@RequestBody LoginDto loginDto,HttpSession session) {
	    
		 
		 Optional<UserProfile> userProfile= userRepo.findById(loginDto.getUserName());
		 if(userProfile.isPresent() && userProfile.get().getPassword()==loginDto.getPassword()) {
			 session.setAttribute("user", userProfile.get());
				return "user logged in sucessfully";
		 }
		 else	 {
		   return "user name and password or not matching plese try again";
		 }
	} 
	@PostMapping("/user/profile/logout")
   public String userLogout(@RequestBody LoginDto loginDto,HttpSession session) {
	    
		 
		 Optional<UserProfile> userProfile= userRepo.findById(loginDto.getUserName());
		 if (userProfile.isPresent()) {
			 session.invalidate();
				return "user logged out sucessfully";
		 }
		 else {
			 return "no active session found for user";
		 }
	
   }
	// Example method to add shares to a user
	@PostMapping("/addshares")
	public void addSharesToUser(String userName, Set<Shares> shares) {
	    UserProfile user = userRepo.findById(userName).orElseThrow(() -> new RuntimeException("User not found"));
	    user.getShares().addAll(shares);
	    userRepo.save(user);
	}

	
	
}
