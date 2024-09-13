package com.ShareMarketProject.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.entity.UserProfile;
import com.ShareMarketProject.repo.SharesRepo;
import com.ShareMarketProject.repo.UserRepo;

@Service
public class SharesService {

    @Autowired
    private SharesRepo sharesRepo;

    @Autowired
    private UserRepo userRepo;

    // Find Shares by ID
    public Optional<Shares> findById(int sharesId) {
        return sharesRepo.findById(sharesId);
    }

    // Buy Shares
    public boolean buyShares(UserProfile userProfile, Shares shares, int quantity) {
        if (shares.getQuantity() >= quantity) {
            // Update Shares quantity
            shares.setQuantity(shares.getQuantity() - quantity);
            shares.setTotalPrice(shares.getQuantity()*shares.getPrice());
            sharesRepo.save(shares);

            // Update UserProfile shares
            userProfile.getShares().add(shares);
            userRepo.save(userProfile);
         
            return true;
        }
        return false;
    }
    
    // Sell Shares
    public boolean sellShares(UserProfile userProfile, Shares shares, int quantity) {
        if (userProfile.getShares().contains(shares) && shares.getQuantity() >= quantity) {
            // Update Shares quantity
            shares.setQuantity(shares.getQuantity() + quantity);
            shares.setTotalPrice(shares.getQuantity()*shares.getPrice());
            sharesRepo.save(shares);

            // Update UserProfile shares
            userProfile.getShares().remove(shares);
            userRepo.save(userProfile);

            return true;
        }
        return false;
    }
}
