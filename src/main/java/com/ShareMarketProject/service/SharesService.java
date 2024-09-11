package com.ShareMarketProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.repo.SharesRepo;

@Service
public class SharesService {
    @Autowired
	SharesRepo sharesRepo;

	public Shares buyShares(Shares shares) {
		return sharesRepo.save(shares);
	}

	public Shares sellShares(Shares shares) {
		// TODO Auto-generated method stub
		 sharesRepo.delete(shares);
		 return shares;
	}
	
    
}
