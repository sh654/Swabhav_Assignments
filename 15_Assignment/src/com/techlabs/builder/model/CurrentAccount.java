package com.techlabs.builder.model;

public class CurrentAccount implements IAccounts{

	private String accountName;
	private long accountNumber;
	private double balance;
	private double overDraftLimit;
	
	
	
	public CurrentAccount(String accountName, long accountNumber, double balance, double overDraftLimit) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public void credit(double amount) {
		// TODO Auto-generated method stub
		if(amount>0)
		balance += amount;
	}

	@Override
	public void debit(double amount) {
		// TODO Auto-generated method stub
		if(balance + overDraftLimit >= amount)
			balance -= amount;
		
		System.out.println("Insufficient funds . Draft Limit Exceeded");
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		return "Savings Account [Account Name =" +accountName+ ", Account Number ="+accountNumber+", Balance="+balance+", Over Draft Limit ="+overDraftLimit+" ]";
	}

	@Override
	public long getAccountNumber() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

}
