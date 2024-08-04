package com.techlabs.builder.model;

public class SavingsAccount implements IAccounts{

	private String accountName;
	private long accountNumber;
	private double balance;
	private double minBalance;
	
	
	
	public SavingsAccount(String accountName, long accountNumber, double balance, double minBalance) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.minBalance = minBalance;
	}

	
	
	@Override
	public void credit(double amount) {
		// TODO Auto-generated method stub
		if(amount<0)
			System.out.println("Enter valid amount!!!");
		
		balance += amount;
		
	}

	@Override
	public void debit(double amount) {
		// TODO Auto-generated method stub
		if(balance-amount<minBalance)
			System.out.println("Check your account"+balance+"min balance is: "+minBalance);
		
		if(amount<0)
			System.out.println("Enter valid amount");
		
		balance-= amount;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		return "Savings Account [Account Name =" +accountName+ ", Account Number ="+accountNumber+", Balance="+balance+", Minimum Balance ="+minBalance+" ]";
	}



	@Override
	public long getAccountNumber() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

	

}
