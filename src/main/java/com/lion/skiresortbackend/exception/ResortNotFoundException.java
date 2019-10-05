package com.lion.skiresortbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResortNotFoundException extends RuntimeException {
	
	public ResortNotFoundException(String message) {
		super(message);
	}

}
