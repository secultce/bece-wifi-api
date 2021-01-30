package com.bece.wifi.api.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
	
	@ExceptionHandler(value = NotFoundRequestException.class)
	public ResponseEntity<Object> handle(NotFoundRequestException e) {
		NotFoundException notFoundException = new NotFoundException(e.getMessage());
		
		return new ResponseEntity<>(notFoundException, HttpStatus.NOT_FOUND);
	}
}
