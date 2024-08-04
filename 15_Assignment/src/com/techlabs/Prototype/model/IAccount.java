package com.techlabs.Prototype.model;

public interface IAccount extends Prototype<IAccount>{

	void credit(double amount);
	void debit(double amount);
	double getBalance();
	long getAccountNumber();
	
}
