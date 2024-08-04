package com.techlabs.Prototype.model;

public class CurrentAccount implements IAccount {
    private String accountName;
    private long accountNumber;
    private double balance;
    private double draftLimit;

    public CurrentAccount(String accountName, long accountNumber, double balance, double draftLimit) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.draftLimit = draftLimit;
    }

    private CurrentAccount(CurrentAccount account) {
        this.accountName = account.accountName;
        this.accountNumber = account.accountNumber;
        this.balance = account.balance;
        this.draftLimit = account.draftLimit;
    }

    @Override
    public CurrentAccount clone() {
        return new CurrentAccount(this);
    }

    @Override
    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public void debit(double amount) {
        if (balance + draftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds including draft limit.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "CurrentAccount [accountName=" + accountName + ", accountNumber=" + accountNumber + ", balance=" + balance + ", draftLimit=" + draftLimit + "]";
    }
}
