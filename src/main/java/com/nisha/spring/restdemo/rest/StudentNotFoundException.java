package com.nisha.spring.restdemo.rest;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);
	}
	
}
