package com.lion.skiresortbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkierNotFoundException extends RuntimeException {

	public SkierNotFoundException(String message) {
		super(message);
	}
	

}
