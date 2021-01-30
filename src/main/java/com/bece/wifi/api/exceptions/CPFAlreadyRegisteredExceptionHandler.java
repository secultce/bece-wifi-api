package com.bece.wifi.api.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CPFAlreadyRegisteredExceptionHandler {

	@ExceptionHandler(value = CPFAlreadyRegisteredRequestException.class)
	public ResponseEntity<Object> handle(CPFAlreadyRegisteredRequestException e) {
		CPFAlreadyRegisteredException cpfFAlreadyRegisteredException 
		= new CPFAlreadyRegisteredException(
			e.getMessage(),
			ZonedDateTime.now(ZoneId.of("Z"))
		);
		
		return new ResponseEntity<>(cpfFAlreadyRegisteredException, HttpStatus.BAD_REQUEST);
	}
}
