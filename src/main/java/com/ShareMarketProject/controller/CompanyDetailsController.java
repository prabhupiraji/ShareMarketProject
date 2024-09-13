package com.ShareMarketProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShareMarketProject.entity.CompanyDetails;
import com.ShareMarketProject.service.CompanyDetailsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@Validated
public class CompanyDetailsController {
       @Autowired
	CompanyDetailsService companyDetailsService;
        
       private static final Logger logger = LoggerFactory.getLogger(CompanyDetailsController.class);
       @PostMapping("/companydetails/add")
       public ResponseEntity<?> addCompanyDetails(@RequestBody CompanyDetails companyDetails){
    	   try {
               logger.info("Request to add company details received: {}", companyDetails);
               CompanyDetails cmpdet = companyDetailsService.addCompanyDetails(companyDetails);
               logger.info("Company details added successfully: {}", cmpdet);
               return new ResponseEntity<>(cmpdet, HttpStatus.CREATED);
           } catch (Exception e) {
               logger.error("An error occurred while adding company details: ", e);
               return new ResponseEntity<>("An error occurred while adding company details", HttpStatus.INTERNAL_SERVER_ERROR);
           }
       }
       @PutMapping("/companydetails/update/{cmpId}")
       public ResponseEntity<?> updateCompanyDetails(
               @Valid @RequestBody CompanyDetails companyDetails,
               @PathVariable @Positive(message = "Company ID must be a positive integer") int cmpId) {
           try {
               logger.info("Request to update company details for ID {}: {}", cmpId, companyDetails);
               CompanyDetails updatedCompanyDetails = companyDetailsService.updateCompanyDetails(companyDetails, cmpId);

               if (updatedCompanyDetails == null) {
                   logger.warn("Company details not found for ID {}", cmpId);
                   return new ResponseEntity<>("Company details not found", HttpStatus.NOT_FOUND);
               }

               logger.info("Company details updated successfully for ID {}: {}", cmpId, updatedCompanyDetails);
               return new ResponseEntity<>(updatedCompanyDetails, HttpStatus.OK);
           } catch (Exception e) {
               logger.error("An error occurred while updating company details for ID {}: ", cmpId, e);
               return new ResponseEntity<>("An error occurred while updating company details", HttpStatus.INTERNAL_SERVER_ERROR);
           }
       }
       
}
