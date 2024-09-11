package com.ShareMarketProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShareMarketProject.entity.CompanyDetails;

public interface CompanyDetailsRepo  extends JpaRepository<CompanyDetails, Integer>{

	
}
