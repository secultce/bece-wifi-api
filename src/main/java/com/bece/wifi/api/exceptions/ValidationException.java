package com.bece.wifi.api.exceptions;

public class ValidationException {
	private String fieldName;
	private String message;
	
	public ValidationException (String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}
}
