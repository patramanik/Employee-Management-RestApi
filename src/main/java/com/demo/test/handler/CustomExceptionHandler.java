package com.demo.test.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.test.exception.EmployeeNotFountException;


@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFountException.class)
	public ResponseEntity<String> handlerEmployeeNotFount(EmployeeNotFountException enfe)
	
	{
		return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
