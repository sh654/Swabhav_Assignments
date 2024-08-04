package com.techlabs.model;

import java.util.ArrayList;
import java.util.Random;


public class BankAccountApp {

	private long accountNumber;
	private String userName;
	private double userBalance;
	private  AccountType  accountType;
	
	public BankAccountApp(long accountNumber, String userName, double userBalance, AccountType accountType) {
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.userBalance = userBalance;
		this.accountType = accountType;
	}
	
	
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	public String getUserName() {
		return this.userName;
	}
	public double getUserBalance() {
		return this.userBalance;
	}
	public AccountType getAccountType() {
		return this.accountType;
	}
	
	double amount;
	public void credit(double amount){
		if (amount > 0) { 
		userBalance += amount;
		System.out.println("Your Account "+ accountNumber + " credited for "+amount+" Current Balance: "+userBalance);
		} else {
			System.out.println("Enter Valid Amount ");
		}
	}
	
	public void debit(double amount) {
		if(amount> userBalance) {
			System.out.println("Insufficient Funds baba");
		} else {
			userBalance -= amount;
			System.out.println("Your Account "+ accountNumber + " credited for "+amount+" Current Balance: "+userBalance);
		}
	}
	
	public void display() {
		
		System.out.println("Your AccountNumber"+ this.accountNumber);
		System.out.println("Your Name: "+ this.userName);
		System.out.println("Your balance: "+this.userBalance);
		System.out.println("Account Type: "+this.accountType);
	}
	
	 public static long generateRandomAccountNumber() {
	        Random rand = new Random();
	        return 1000000000L + (long)(rand.nextDouble() * 8999999999L);
	    }

	    public static BankAccountApp maxBalance(BankAccountApp[] accounts) {
	    	BankAccountApp maxAccount = accounts[0]; //player id
			double maxAcount = accounts[0].getUserBalance();
	        if (accounts == null || accounts.length==0) {
	            return null;
	        }

	        for (BankAccountApp account : accounts) {
	            if (account.getUserBalance() > maxAccount.getUserBalance()) {
	                maxAccount = account;
	            }
	        }
	        return maxAccount;
	    }
	
	
}
