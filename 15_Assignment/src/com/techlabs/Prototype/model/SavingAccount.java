package com.techlabs.Prototype.model;

public class SavingAccount implements IAccount {
    private String accountName;
    private long accountNumber;
    private double balance;
    private double minBalance;

    public SavingAccount(String accountName, long accountNumber, double balance, double minBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    private SavingAccount(SavingAccount account) {
        this.accountName = account.accountName;
        this.accountNumber = account.accountNumber;
        this.balance = account.balance;
        this.minBalance = account.minBalance;
    }

    @Override
    public SavingAccount clone() {
        return new SavingAccount(this);
    }

    @Override
    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public void debit(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to maintain minimum balance.");
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
        return "SavingAccount [accountName=" + accountName + ", accountNumber=" + accountNumber + ", balance=" + balance + ", minBalance=" + minBalance + "]";
    }
}



