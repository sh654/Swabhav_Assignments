package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.exception.EmailNotValidException;
import com.techlabs.exception.PasswordNotValidException;
import com.techlabs.model.User;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			String userEmail = scanner.next();
			String password = scanner.next();
			
			User user = new User(userEmail, password);
			
			System.out.println("User Email is Valid: "+userEmail );
			System.out.println("User password is Valid: "+password);
			
		}catch(EmailNotValidException exception) {
			System.out.println(exception.EmailNotValidException());
		} catch(PasswordNotValidException exception) {
			
			System.out.println(exception.PasswordNotValidExceptionMessage());
		}
	}

}
