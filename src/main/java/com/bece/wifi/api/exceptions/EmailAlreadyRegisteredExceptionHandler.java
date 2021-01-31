package com.bece.wifi.api.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmailAlreadyRegisteredExceptionHandler {

	@ExceptionHandler(value = EmailAlreadyRegisteredRequestException.class)
	public ResponseEntity<Object> handle(EmailAlreadyRegisteredRequestException e) {
		EmailAlreadyRegisteredException emailAlreadyRegisteredException 
		= new EmailAlreadyRegisteredException(
			e.getMessage(),
			ZonedDateTime.now(ZoneId.of("Z"))
		);
		
		return new ResponseEntity<>(emailAlreadyRegisteredException, HttpStatus.BAD_REQUEST);
	}
}
