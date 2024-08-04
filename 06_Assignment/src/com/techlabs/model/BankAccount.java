package com.techlabs.model;

import java.util.Random;

public class BankAccount {

	// accountNumber, name, balance
	
	private long accountNumber;
	private String userName;
	private double userBalance;
	
	//constructor 
	
	public BankAccount(int accountNumber, String userName, double userBalance) {
		this.accountNumber = accountNumber;
//		this.accountNumber = generateRandomAccountNumber();
		this.userName = userName;
		this.userBalance = userBalance;
	}
	
	public void accountNumber() {
		long accountNumberCopy =0;
		Random random = new Random();
		
			for (int i = 0; i < 10; i++) {
				accountNumberCopy += random.nextInt(10);
				if(i != 9) accountNumberCopy *= 10;
			}
			this.accountNumber = accountNumberCopy;
		}
	
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	
	public long getAccounNumber() {
		return this.accountNumber;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public double getUserBalance() {
		return this.userBalance;
	}
	
	private double amount;

	public void credit(double amount) {
		if(amount>0) {
			userBalance += amount;
			System.out.println("Your Account "+ accountNumber + " credited for "+amount+" Current Balance: "+userBalance);
		}
	}
	
	public void debit(double amount) {
		if(amount<=userBalance && amount>0) {
			userBalance -= amount;
			System.out.println("Your Account "+accountNumber+ " debited for "+amount+" Current Balance: "+userBalance);
	} else {
		System.out.println("Enter valid Funds: ");
	}
		


	}
}
