package com.bece.wifi.api.exceptions;

import java.time.ZonedDateTime;

import com.bece.wifi.api.enums.ErrorsEnum;

public class CPFAlreadyRegisteredException {
	private final String message;
	private final ErrorsEnum error = ErrorsEnum.CPF_ALREADY_EXIST;
	private final ZonedDateTime timestamp;
	
	public CPFAlreadyRegisteredException(String message,  
										 ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}

	public ErrorsEnum getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
}
