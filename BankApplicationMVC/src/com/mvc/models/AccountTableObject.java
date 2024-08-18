package com.mvc.models;

import java.math.BigDecimal;

public class AccountTableObject {
    private int accountId;
    private int customerId;
    private int userId;
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
    
    

    public AccountTableObject( String accountNumber, BigDecimal balance, int customerId) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		
	}

	
	// Getters and Setters
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
