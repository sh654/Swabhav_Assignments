package com.techlabs.model;

public class SavingAccount extends Account{

	private static double  min_balance = 1000;

	public SavingAccount(long accountNumber, String accountName, double accountBalance) {
		super(accountNumber, accountName, accountBalance);
//		this.min_balance = min_balance;
	}
	
	@Override
	public void debit(double amount) {
		if(accountBalance - amount > min_balance) {
			System.out.println("Amount debited: "+amount);
			System.out.println("Balance Reamining: "+accountBalance);
		} else {
			System.out.println("Sorry your Minimum balance limit is hit");
		}
	}
	
	public void display() {
		super.display();
		System.out.println("Account Type : Savings");
		System.out.println("Min Balance : "+min_balance);
		
	}
}
