package com.techlabs.model;

public class Account {
	
	protected long accountNumber;
	protected String accountName;
	protected double accountBalance;
	public Account(long accountNumber, String accountName, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}
	
	public void credit(double amount) {
		if(amount < 0) {
			System.out.println("Enter valid Amount");
			return;
		} else {
		accountBalance += amount;
		System.out.println("Amount credited: "+amount);
		System.out.println("new balance : "+accountBalance);
		return;
		}
	}
	
	public void debit(double amount) {
		if(accountBalance < amount) {
			System.out.println("Insufficient funds");
			return;
		} else {
			accountBalance -= amount;
			System.out.println("Amount credited: "+amount);
			System.out.println("new balance : "+accountBalance);
			return;
		}
	}
	
	public void display() {
		 System.out.println("Account No: " + accountNumber);
	     System.out.println("Name: " + accountName);
	     System.out.println("Balance: " + accountBalance);
	}
	
	
}
