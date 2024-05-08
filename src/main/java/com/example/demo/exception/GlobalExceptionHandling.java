package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInvoiceNotFoundException(
			EmployeeNotFoundException exception){
		
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(
						exception.getMessage(), 
						"Record not found", 
						"DATA NOT FOUND FOR REQUESTED ID", 
						"406"), 
				HttpStatus.NOT_ACCEPTABLE);
	}

}
