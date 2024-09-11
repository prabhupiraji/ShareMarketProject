package com.ShareMarketProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ShareMarketProject.entity.UserProfile;

public interface UserRepo extends JpaRepository<UserProfile, String> {

}
