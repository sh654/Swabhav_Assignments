package com.techlabs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlabs.model.AccountApp;

public class AccountAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<AccountApp> accounts = new ArrayList<>();
		
		boolean isExit = false;
		 do {
	            System.out.println("Welcome, choose any option:");
	            System.out.println("1) Create Account");
	            System.out.println("2) Debit Money");
	            System.out.println("3) Credit Money");
	            System.out.println("4) Display All Records ");
	            System.out.println("5) Display Record with maximum Balance");
	            System.out.println("6) Display Records Descending order of Balance");
	            System.out.println("7) Exit");
	 
	            int choice = scanner.nextInt();
	            switch (choice) {
	            case 1:
	            		createAccount(scanner, accounts);
	            	break;
	            case 2:
	            	    debitMoney(scanner, accounts);
	            	    break;
	            case 3:
	            	    creditMoney(scanner, accounts);
	            	    break;
	            case 4:
	            		displayAll(accounts);
	            	    break;
	            case 5: 
	            		double maxBal = maximumBalance(accounts);
	            		System.out.println(maxBal);
	            		break;
	            case 6:
	            		descrecordsOrder(accounts);
	            	    break;
	            case 7:
	            		isExit = true;
	            		break;
	            default:
	            	System.out.println("Enter valid bc");
	            }
		 } while(!isExit);
	} 
	
	private static void displayAll(ArrayList<AccountApp> accounts) {
		// TODO Auto-generated method stub
		for(AccountApp account : accounts) {
			account.toString();
		}
	}

	private static void descrecordsOrder(ArrayList<AccountApp> accounts) {
		// TODO Auto-generated method stub
		 for (int i = 0; i < accounts.size() - 1; i++) {
	            int maxIndex = i;
	            for (int j = i + 1; j < accounts.size(); j++) {
	                if (accounts.get(j).getAccountBalance() > accounts.get(maxIndex).getAccountBalance()) {
	                    maxIndex = j;
	                }
	            }
	            // Swap elements
	            AccountApp temp = accounts.get(maxIndex);
	            accounts.set(maxIndex, accounts.get(i));
	            accounts.set(i, temp);
	            accounts.toString();
	}
}

	private static double maximumBalance(ArrayList<AccountApp> accounts) {
		// TODO Auto-generated method stub
		double maxBalance  = 0;
		for(AccountApp account : accounts) {
			if(maxBalance < account.getAccountBalance()) {
				maxBalance = account.getAccountBalance();
			}
		}
		return maxBalance;
	}

	private static void creditMoney(Scanner scanner, ArrayList<AccountApp> accounts) {
		// TODO Auto-generated method stub
		System.out.println("Enter your account Number: ");
		long accountNo = scanner.nextLong();
		System.out.println("Enter amount to be debited: ");
		double amount = scanner.nextDouble();
		for(AccountApp account : accounts) {
			if(account.getAccountNumber() == accountNo) {
				account.credit(amount);
			}
		}
	}

	private static void debitMoney(Scanner scanner, ArrayList<AccountApp> accounts) {
		// TODO Auto-generated method stub
		System.out.println("Enter your account Number: ");
		long accountNo = scanner.nextLong();
		System.out.println("Enter amount to be debited: ");
		double amount = scanner.nextDouble();
		
		for(AccountApp account : accounts) {
			if(account.getAccountNumber() == accountNo) {
				account.debit(amount);
			}
		}
		
	}
	private static void createAccount(Scanner scanner, ArrayList<AccountApp> accounts) {
		
			 System.out.println("Enter Number of Accounts to be created: ");
             int size = scanner.nextInt();
             
             for(int i =0; i<size; i++) {
            	 System.out.println("Account Number: ");
                 long accountNumber = scanner.nextLong();
                 System.out.println("Account Holder Name: ");
                 String accountName = scanner.next();
                 System.out.println("Account Balance: ");
                 double accountBalance = scanner.nextDouble();
                 System.out.println("Account type \n 1) Savings \n 2) Current");
                 String accountType = scanner.next();
                 accounts.add(new AccountApp(accountNumber,accountName, accountBalance, accountType));
             }  
         }
                
		
	}

