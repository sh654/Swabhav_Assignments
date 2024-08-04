package com.techlabs.model;
import com.techlabs.exception.MinBalanceException;
public class SavingsAccount extends BankAccountApp {
    private double minBalance;
    public SavingsAccount(long accountNumber, String accountName, double accountBalance, String accountType, double minBalance) {
        super(accountNumber, accountName, accountBalance, accountType);
        this.minBalance = minBalance;
    }
    @Override
    public void credit(double amount) {
        if (amount < 0) {
            System.out.println("Enter Valid amount : ");
            return;
        }
        accountBalance += amount;
        System.out.println("Amount Credited: " + amount);
        System.out.println("Total Balance: " + accountBalance);
    }
    @Override
    public void debit(double amount) throws MinBalanceException {
        if (amount < 0) {
            System.out.println("Enter Valid amount");
            return;
        }
        if (accountBalance - amount < minBalance) {
            throw new MinBalanceException("Withdrawal would cause balance to fall below the minimum balance. Please maintain the minimum balance.");       
        }
        accountBalance -= amount;
        System.out.println("Amount Debited: " + amount);
        System.out.println("Total Balance: " + accountBalance);
    }
    public void forceDebit(double amount) {
        accountBalance -= amount;
        System.out.println("Amount Debited: " + amount);
        System.out.println("Total Balance : " + accountBalance);
        System.out.println("You are sort of " +(minBalance-accountBalance)+ " do deposit money before month end to avoid charges!! of 15%");
    }
 
    @Override
    public String toString() {
        return "SavingsAccount [minBalance=" + minBalance + ", accountBalance=" + accountBalance
                + ", getAccountNumber()=" + getAccountNumber() + ", getAccountName()=" + getAccountName()
                + ", getAccountBalance()=" + getAccountBalance() + ", getAccountType()=" + getAccountType()
                + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }
}