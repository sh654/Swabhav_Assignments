package com.techlabs.model;

public class SavingsClass extends AccountApp{

	public SavingsClass(long accountNumber, String accountName, double accountBalance, String accountType) {
		super(accountNumber, accountName, accountBalance, accountType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SavingsClass [getAccountNumber()=" + getAccountNumber() + ", getAccountName()=" + getAccountName()
				+ ", getAccountBalance()=" + getAccountBalance() + ", getAccountType()=" + getAccountType()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	
}
