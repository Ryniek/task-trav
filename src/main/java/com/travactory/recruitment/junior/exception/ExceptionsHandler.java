package com.travactory.recruitment.junior.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException (
            ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorMessage(HttpStatus.NOT_FOUND, exception));
    }
	
	@ExceptionHandler(ConstraintViolationException.class)
	  public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {
	    List<CustomValidationMessage> errorMessages = exception.getConstraintViolations()
	        .stream()
	        .map(error -> {
	        	String errorField = error.getPropertyPath().toString();
	        	return new CustomValidationMessage(errorField.substring(errorField.lastIndexOf(".") + 1), error.getMessage());
	        })
	        .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomErrorMessage(HttpStatus.NOT_FOUND, exception, errorMessages));
	  }
}
