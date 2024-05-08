package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String messge){
		super(messge);
	}

}
