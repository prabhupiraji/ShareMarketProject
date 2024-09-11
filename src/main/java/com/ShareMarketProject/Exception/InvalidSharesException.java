package com.ShareMarketProject.Exception;

import org.springframework.http.ResponseEntity;

public class InvalidSharesException  extends RuntimeException{

	public InvalidSharesException(String message){
		super(message);
	}
}
