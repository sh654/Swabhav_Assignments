package com.techlabs.exception;

public class PasswordNotValidException extends RuntimeException{

	public PasswordNotValidException(String password) {
		// TODO Auto-generated constructor stub
		super();
	}

	public String PasswordNotValidExceptionMessage() {
		// TODO Auto-generated method stub
		return "Enter valid password of size 8-digits and more";
	}
}
