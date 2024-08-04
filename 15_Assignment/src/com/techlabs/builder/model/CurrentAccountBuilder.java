package com.techlabs.builder.model;

public class CurrentAccountBuilder implements AccountBuilder{

	private String accountName;
	private long accountNumber;
	private double balance;
	private double overDraftLimit;
	
	
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
	public AccountBuilder setAdditionalFeature(double overDraftLimit) {
		// TODO Auto-generated method stub
		this.overDraftLimit = overDraftLimit;
		return this;
	}

	@Override
	public IAccounts build() {
		// TODO Auto-generated method stub
		return new CurrentAccount(accountName, accountNumber, balance, overDraftLimit);
	}

}
