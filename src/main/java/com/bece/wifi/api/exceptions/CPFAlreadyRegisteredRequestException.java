package com.bece.wifi.api.exceptions;

public class CPFAlreadyRegisteredRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CPFAlreadyRegisteredRequestException(String message) {
		super(message);
	}
	
	public CPFAlreadyRegisteredRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
