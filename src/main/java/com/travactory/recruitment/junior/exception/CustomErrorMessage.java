package com.travactory.recruitment.junior.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomErrorMessage {
	private HttpStatus status;
	private String errorMessage;
	private Date timestamp;
	private List<CustomValidationMessage> validationErrors;
	
	public CustomErrorMessage(HttpStatus status, Throwable exception) {
		this.status = status;
		this.errorMessage = exception.getMessage();
		this.timestamp = new Date();
	}
	
	public CustomErrorMessage(HttpStatus status, Throwable exception, List<CustomValidationMessage> validationErrors) {
		this.status = status;
		this.errorMessage = exception.getMessage();
		this.timestamp = new Date();
		this.validationErrors = validationErrors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public List<CustomValidationMessage> getValidationErrors() {
		return validationErrors;
	}
}
