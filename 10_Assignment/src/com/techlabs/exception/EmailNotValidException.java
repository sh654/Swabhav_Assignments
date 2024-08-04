package com.techlabs.exception;

public class EmailNotValidException extends RuntimeException{

//	public EmailNotValidException(String message) {
//		super(message);
//	}

	public EmailNotValidException(String userEmail) {
		// TODO Auto-generated constructor stub
		super();
	}

	public String EmailNotValidException() {
		// TODO Auto-generated method stub
		return "Your email is  Invalid please include @ and . and size greater than 5 less than 50";
	}
}
