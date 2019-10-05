package com.lion.skiresortbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidResortNameException extends RuntimeException {
	
	public InvalidResortNameException(String message) {
		super(message);
	}
}