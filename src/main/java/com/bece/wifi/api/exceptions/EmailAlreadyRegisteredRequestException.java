package com.bece.wifi.api.exceptions;

public class EmailAlreadyRegisteredRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegisteredRequestException(String message) {
		super(message);
	}
	
	public EmailAlreadyRegisteredRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
