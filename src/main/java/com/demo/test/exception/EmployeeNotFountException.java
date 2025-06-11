package com.demo.test.exception;

public class EmployeeNotFountException  extends RuntimeException{
	
	public EmployeeNotFountException() {
		super();
	}
	
	public EmployeeNotFountException(String msg) {
		super(msg);
	}
	
}
