package com.ShareMarketProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShareMarketProject.entity.CompanyDetails;
import com.ShareMarketProject.repo.CompanyDetailsRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyDetailsService {
      @Autowired
	CompanyDetailsRepo companyDetailsRepo;

	public CompanyDetails addCompanyDetails(CompanyDetails companyDetails) throws Exception {
		// TODO Auto-generated method stub
		if (companyDetailsRepo.existsById(companyDetails.getCmpId())) {
	        throw new Exception("A company with this name already exists");
	    }
		else
		return companyDetailsRepo.save(companyDetails);
	}

	public CompanyDetails updateCompanyDetails(CompanyDetails companyDetails, int cmpId) {
		// TODO Auto-generated method stub
		if (companyDetailsRepo.existsById(cmpId)) {
			companyDetails.setCmpId(cmpId);
			return companyDetailsRepo.save(companyDetails);
	    }
		else {
		throw new EntityNotFoundException("Company with ID " + cmpId + " not found");
		}
	}
	
      
}
