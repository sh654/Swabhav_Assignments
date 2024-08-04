package com.techlabs.model;

import java.util.Scanner;

public class AccountApp {
	
	private long accountNumber;
	private String accountName;
	private double accountBalance;
	private String accountType;
	
	public AccountApp(long accountNumber, String accountName, double accountBalance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	
public void debit(double amount) {
        
        if(amount < 0)
            System.out.println("Amount cannot be zero");
            
        if(amount > this.accountBalance) {
            System.out.println("You lack sufficient funds!!!!");
            System.out.println("Do you want to proceed and make your balance negative? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("yes")) {
                this.accountBalance -= amount;
                System.out.println("You Debited : "+amount);
                System.out.println("Your current Balance: "+accountBalance);
            } else {
                System.out.println("Ok your withdraw is stop");
            }
        }
        
        this.accountBalance -= amount;
        System.out.println("You Debited : "+amount);
        System.out.println("Your current Balance: "+accountBalance);
        
    }
 
    public void credit(double amount) {
        if(amount <= 0)
            System.out.println("Please enter valid amount");
        
        this.accountBalance += amount;
        System.out.println("Your Account Credited for : "+amount);
        System.out.println("Your Current Balance: "+accountBalance);
    }
	
	public long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getAccountName() {
		return accountName;
	}



	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}



	public double getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	@Override
	public String toString() {
		return "AccountApp [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + ", accountType=" + accountType + "]";
	}


	
	
	
}
