package com.bece.wifi.api.exceptions;

import java.time.ZonedDateTime;

import com.bece.wifi.api.enums.ErrorsEnum;

public class EmailAlreadyRegisteredException {
	private final String message;
	private final ErrorsEnum error = ErrorsEnum.EMAIL_ALREADY_EXIST;
	private final ZonedDateTime timestamp;
	
	public EmailAlreadyRegisteredException(String message,  
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
