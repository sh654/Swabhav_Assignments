package com.techlabs.model;
import com.techlabs.exception.MinBalanceException;
import com.techlabs.exception.OverDraftLimitExceedeException;
import java.util.Random;
import java.util.Scanner;
import com.techlabs.exception.MinBalanceException;
public class BankAccountApp {
    private final long accountNumber;
    private String accountName;
    protected double accountBalance;
    private String accountType;
    public BankAccountApp(long accountNumber, String accountName, double accountBalance, String accountType) {
        super();
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
 
    public void debit(double amount) throws MinBalanceException, OverDraftLimitExceedeException{
        
        if(amount < 0)
            System.out.println("Amount cannot be zero");
            
        if(amount > this.accountBalance) {
            System.out.println("You lack sufficient funds!!!!");
            System.out.println("Do you want to proceed and make your balance negative? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("yes")) {
                this.accountBalance -= amount;
                System.out.println("You Debited : "+amount);
                System.out.println("Your current Balance: "+accountBalance);
            } else {
                System.out.println("Ok your withdraw is stop");
            }
        }
        
        else {
            throw new MinBalanceException("Your Withdraw Failed"); // note here which runs?
        }
        
        this.accountBalance -= amount;
        System.out.println("You Debited : "+amount);
        System.out.println("Your current Balance: "+accountBalance);
        
    }
 
    public void credit(double amount) throws OverDraftLimitExceedeException {
        if(amount <= 0)
            System.out.println("Please enter valid amount");
        
        this.accountBalance += amount;
        System.out.println("Your Account Credited for : "+amount);
        System.out.println("Your Current Balance: "+accountBalance);
    }
 
    @Override
    public String toString() {
        return "BankAccountApp [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountBalance="
                + accountBalance + ", accountType=" + accountType + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }
 
 
    
    
}