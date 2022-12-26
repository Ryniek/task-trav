package com.travactory.recruitment.junior.exception;

public class CustomValidationMessage {
	private String field;
	private String errorMessage;
	
	public CustomValidationMessage(String field, String errorMessage) {
		this.field = field;
		this.errorMessage = errorMessage;
	}
	
	public String getField() {
		return field;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
