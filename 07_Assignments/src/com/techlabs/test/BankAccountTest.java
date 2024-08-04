package com.techlabs.test;
import java.util.Scanner;

import com.techlabs.model.AccountType;
import com.techlabs.model.BankAccountApp;
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter size of Enteries");
        int size = scanner.nextInt();
		BankAccountApp [] bank = new BankAccountApp[size];
		
		for(int i=0; i<bank.length; i++) {
//			System.out.println("Enter Bank Account Number: ");
//			int playerId = scanner.nextInt();
			System.out.println("Enter Bank Account Holder Name: ");
			String userName = scanner.next();
			System.out.println("Enter Bank Account balance: ");
			double userBalance  = scanner.nextDouble();
			System.out.println("Enter Bank Account Type: ");
			AccountType accountType;
			
			bank[i] = new BankAccountApp(BankAccountApp.generateRandomAccountNumber(), userName, userBalance, accountType);
		}
		for(int i=0; i<bank.length ; i++) {
			bank[i].display();
			
		}
		
//		BankAccountApp bankUser = new BankAccountApp(size, null, size, null);
		boolean isExit = false;
		double amount;
		
		 BankAccountApp maxBalanceAccount = BankAccountApp.maxBalance(bank);

	        // Display the details of the account with the maximum balance
	        if (maxBalanceAccount != null) {
	            System.out.println("Account with the maximum balance:");
	            maxBalanceAccount.display();
	        } else {
	            System.out.println("No accounts to display.");
	        }

	        // Display the details of the account with the maximum balance
	        if (maxBalanceAccount != null) {
	            System.out.println("Account with the maximum balance:");
	            maxBalanceAccount.display();
	        } else {
	            System.out.println("No accounts to display.");
	        }
		
		for(int i=0; i<bank.length ; i++) {
		
		while(!isExit) {
			amount = 0;
			System.out.println("Bank Menu: ");
			System.out.println(" 1. Check Balance \n 2. Credit Money \n 3. Debit Money \n 4. Exit");
			System.out.println("Please choose an option: ");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Your acoount has : " +bank[i].getUserBalance());
					break;
				case 2:
					System.out.println("Enter the amount to credit: ");
					amount = scanner.nextDouble();
					bank[i].credit(amount);
					break;
				case 3:
					System.out.println("Enter the amount to debit: ");
					amount = scanner.nextDouble();
					bank[i].credit(amount);
					break;
					/*
				case 4:
					System.out.println("Enter new name: ");
					bankUser.setUserName(scanner.next());
					bankUser.getUserName();
					break;
					*/
				case 4:
					System.out.println("Thank you for using atm, Good Bye!");
					isExit = true;
					break;
				default:
					System.out.println("Wrong choice!");
					break;
				}
		}
		}
		scanner.close();
	}

}
