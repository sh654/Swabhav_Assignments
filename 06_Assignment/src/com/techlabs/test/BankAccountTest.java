package com.techlabs.test;

import java.util.*;
import java.util.Scanner;

import com.techlabs.model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean isExit = false;
		
		Scanner scanner = new Scanner(System.in);
		
		
		BankAccount bankUser1 = new BankAccount(0, null, 0);
	    bankUser1.setUserName("Shivam Upadhyay");;
	    
		
		bankUser1.setUserBalance(10000);
		bankUser1.getAccounNumber();
		
		System.out.println("Welcome to your bank account : "+bankUser1.getUserName());
		System.out.println("Your Account Number : "+bankUser1.getAccounNumber());
		System.out.println("Your balance : "+bankUser1.getUserBalance());
		int amount;
		
		while(!isExit) {
			amount = 0;
			System.out.println(" 1. Check Balance \n 2. Credit Money \n 3. Debit Money \n 4. Change Name \n 5. Exit");
			System.out.println("Enter your Choice: ");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1 : 
				System.out.println("Welcome to your account" +bankUser1.getUserName()+ "Your Balance: "+bankUser1.getUserBalance());
				break;
			case 2 :
				System.out.println("Enter amount to be Credited : ");
				amount = scanner.nextInt();
				bankUser1.credit(amount);
				break;
				
			case 3 :
				System.out.println("Enter amount to be Credited : ");
				amount = scanner.nextInt();
				bankUser1.debit(amount);
				break;
				
			case 4:
			     System.out.println("Enter new name: ");
			     bankUser1.setUserName(scanner.next());
			     break;
			    case 5:
			     System.out.println("Thank you for using atm, Good Bye!");
			     isExit = true;
			     break;
			     
			    default:
			     System.out.println("Wrong choice!");
			     break;
			}
		}
		
		
	}

}
