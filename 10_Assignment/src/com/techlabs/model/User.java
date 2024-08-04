package com.techlabs.model;

import com.techlabs.exception.EmailNotValidException;
import com.techlabs.exception.PasswordNotValidException;

public class User {

	private String userEmail;
	private String password;
	
	
	 public User(String userEmail, String password) throws EmailNotValidException, PasswordNotValidException {
//	        setUserName(userEmail); // Validate and set email
//	        setPassword(password); // Validate and set password
		 	if (!validateEmail(userEmail)) {
	            throw new EmailNotValidException("Email format is not valid: " + userEmail);
	        }
	        this.userEmail = userEmail;
	        if (!validatePassword(password)) {
	            throw new PasswordNotValidException("Password requirements not met."+password);
	        }
	        this.password = password;
	    }

	    public String getUserEmail() {
	        return userEmail;
	    }

	    public void setUserName(String userEmail) throws EmailNotValidException {
	        if (!validateEmail(userEmail)) {
	            throw new EmailNotValidException("Email format is not valid, Note @ & . not together neither at start or end: " + userEmail);
	        }
	        this.userEmail = userEmail;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) throws PasswordNotValidException {
	        if (!validatePassword(password)) {
	            throw new PasswordNotValidException("Password requirements not met."+password);
	        }
	        this.password = password;
	    }

	    private boolean validatePassword(String password) {
	        if (password == null || password.isEmpty()) {
	            return false;
	        }
	        // Password must be between 8 to 20 characters
	        return password.length() >= 8 && password.length() <= 20;
	    }

	    private boolean validateEmail(String userEmail) {
	        if (userEmail == null || userEmail.isEmpty()) {
	            return false;
	        }
	        // Check if email starts with '@' or '.'
	        if (userEmail.startsWith("@") || userEmail.startsWith(".")) {
	            return false;
	        }
	        
	        // Check if '.' or '@' appear consecutively
	        if (userEmail.contains("..") || userEmail.contains("@.") || userEmail.contains(".@")) {
	            return false;
	        }
	        // Email must contain '@' and '.'
	        if (!userEmail.contains("@") || !userEmail.contains(".")) {
	            return false;
	        }
	        // Email length must be between 5 to 50 characters
	        return userEmail.length() >= 5 && userEmail.length() <= 50;
	    }

	    @Override
	    public String toString() {
	        return "User [userEmail=" + userEmail + ", password=" + password + "]";
	    }
	}