package com.employee.exception;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<Object>nameExceptionHandler(InvalidNameException ne)
	{
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<Object>ageExceptionHandler(InvalidAgeException ae){
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object>idExceptionHandler(IdNotFoundException ie)
	{
		return new ResponseEntity<>(ie.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	

}
