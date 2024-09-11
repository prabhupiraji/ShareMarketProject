package com.ShareMarketProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShareMarketProject.entity.Shares;

public interface SharesRepo  extends JpaRepository<Shares, Integer>{

}
