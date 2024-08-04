package com.techlabs.builder.model;

public interface IAccounts {
    void credit(double amount);
    void debit(double amount);
    double getBalance();
    String getAccountDetails();
	long getAccountNumber();
}