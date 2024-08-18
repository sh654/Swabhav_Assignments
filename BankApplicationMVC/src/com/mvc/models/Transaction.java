package com.mvc.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal balance;
    private String receiverAccountNumber;
    private Timestamp date;
    private String accountNumber;

    // Getters and Setters
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

	@Override
	public String toString() {
		return "Transaction [transactionType=" + transactionType + ", amount=" + amount + ", balance=" + balance
				+ ", receiverAccountNumber=" + receiverAccountNumber + ", date=" + date + ", accountNumber="
				+ accountNumber + "]";
	}
}
