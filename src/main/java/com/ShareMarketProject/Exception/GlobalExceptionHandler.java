package com.ShareMarketProject.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(InvalidSharesException.class)
	public ResponseEntity<String> handleInvalidSharesException(InvalidSharesException ex) {
        logger.error("InvalidSharesException occurred: ", ex);
        return new ResponseEntity<String>("Invalid shares request: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(SharesNotAvailableException.class)
     public ResponseEntity<String> handleSharesNotAvailableException(SharesNotAvailableException ex){
    	 logger.error("SharesNotAvailableException occured: ", ex);
    	 return new ResponseEntity<String>("SharesNotAvailableException: " + ex.getMessage(), HttpStatus.NOT_FOUND);
     }
}
