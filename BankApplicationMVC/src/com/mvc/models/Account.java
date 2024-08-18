package com.mvc.models;

import java.math.BigDecimal;

public class Account {
	
    private int accountId;
    private int customerId;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;

    // Getters and Setters

    public Account() {}
    
    public Account(int customerId, String accountNumber, String accountType, BigDecimal balance) {
		// TODO Auto-generated constructor stub
    	this.customerId = customerId;
    	this.accountNumber = accountNumber;
    	this.accountType = accountType;
    	this.balance = balance;
	}

	public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
