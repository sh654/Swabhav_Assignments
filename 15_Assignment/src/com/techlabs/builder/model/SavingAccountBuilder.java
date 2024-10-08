package com.techlabs.builder.model;

public class SavingAccountBuilder implements AccountBuilder{

	private String accountName;
	private long accountNumber;
	private double minBalance;
	private double balance;
	
	@Override
	public AccountBuilder setAccountName(String accountName) {
		// TODO Auto-generated method stub
		this.accountName = accountName;
		return this;
	}

	@Override
	public AccountBuilder setAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber = accountNumber;
		return this;
	}

	@Override
	public AccountBuilder setBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance = balance;
		return this;
	}

	@Override
	public AccountBuilder setAdditionalFeature(double minBalance) {
		// TODO Auto-generated method stub
		this.minBalance = minBalance;
		return this;
	}

	@Override
	public IAccounts build() {
		// TODO Auto-generated method stub
		return new SavingsAccount(accountName, accountNumber, balance, minBalance);
	}

}
