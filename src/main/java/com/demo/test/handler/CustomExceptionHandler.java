package com.demo.test.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.test.dto.ApiResponse;
import com.demo.test.exception.EmployeeNotFountException;


@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFountException.class)
	public ResponseEntity<ApiResponse<String>> handlerEmployeeNotFount(EmployeeNotFountException enfe)
	
	{
		ApiResponse<String> response = new ApiResponse<String>(false,enfe.getMessage());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
