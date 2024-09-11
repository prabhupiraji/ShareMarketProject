package com.ShareMarketProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShareMarketProject.Exception.GlobalExceptionHandler;
import com.ShareMarketProject.Exception.InvalidSharesException;
import com.ShareMarketProject.Exception.SharesNotAvailableException;
import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.service.SharesService;

@RestController
public class SharesController {
      @Autowired
	  SharesService sharesService;
	  
		private static final Logger logger = LoggerFactory.getLogger(SharesController.class);
      @PostMapping("/user/buyshares")
      public ResponseEntity<?> buyShares(@Validated @RequestBody Shares shares) {
          try {
              logger.info("Request to buy shares received: {}", shares);
              Shares purchasedShares = sharesService.buyShares(shares);
              return new ResponseEntity<>(purchasedShares, HttpStatus.OK);
          } catch (InvalidSharesException e) {
              logger.error("Invalid shares request: {}", shares, e);
              return new ResponseEntity<>("Invalid shares request", HttpStatus.BAD_REQUEST);
          } catch (SharesNotAvailableException e) {
              logger.error("Shares not available: {}", shares, e);
              return new ResponseEntity<>("Shares not available", HttpStatus.NOT_FOUND);
          } catch (Exception e) {
              logger.error("An unexpected error occurred: ", e);
              return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
      @ExceptionHandler(Exception.class)
      public ResponseEntity<String> handleException(Exception e) {
          logger.error("Global exception handler: ", e);
          return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
      }
      
      @DeleteMapping("/user/sellshares")
      public ResponseEntity<?> sellShares(@RequestBody Shares shares){
    	  
		try {
            logger.info("Request to sell shares received: {}", shares);
            Shares selledShares = sharesService.sellShares(shares);
        	return new ResponseEntity<Shares>(selledShares,HttpStatus.OK);
        } catch (InvalidSharesException e) {
            logger.error("Invalid shares sell request: {}", shares, e);
            return new ResponseEntity<>("Invalid shares request", HttpStatus.BAD_REQUEST);
        } catch (SharesNotAvailableException e) {
            logger.error("Shares not available: {}", shares, e);
            return new ResponseEntity<>("Shares not available", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("An unexpected error occurred: ", e);
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
}
