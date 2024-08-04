package com.techlabs.model;
 
import com.techlabs.exception.OverDraftLimitExceedeException;
 
public class CurrentAccount extends BankAccountApp {
    
    private double over_draft_limit;
    private double over_draft_limit_used = 0;
 
    public CurrentAccount(long accountNumber, String accountName, double accountBalance, String accountType, double over_draft_limit) {
        super(accountNumber, accountName, accountBalance, accountType);
        this.over_draft_limit = over_draft_limit;
    }
    
    @Override
    public void debit(double amount) throws OverDraftLimitExceedeException {
        if (accountBalance + over_draft_limit < amount) {
            throw new OverDraftLimitExceedeException("Insufficient funds. Overdraft limit exceeded.");
        }
        if (accountBalance < amount) {
            over_draft_limit_used += (amount - accountBalance);
            accountBalance = 0;
        } else {
            accountBalance -= amount;
        }
        System.out.println("Amount Debited: " + amount);
        System.out.println("Total Balance: " + accountBalance);
        System.out.println("Overdraft Limit Used: " + over_draft_limit_used);
    }
    
    @Override
    public void credit(double amount) throws OverDraftLimitExceedeException {
        if (over_draft_limit_used > 0) {
            if (amount >= over_draft_limit_used) {
                amount -= over_draft_limit_used;
                over_draft_limit_used = 0;
            } else {
                over_draft_limit_used -= amount;
                amount = 0;
            }
        }
        accountBalance += amount;
        System.out.println("Amount Credited: " + amount);
        System.out.println("Total Balance: " + accountBalance);
        System.out.println("Overdraft Limit Used: " + over_draft_limit_used);
    }
 
    public void setOverDraftLimit(double over_draft_limit) {
        this.over_draft_limit = over_draft_limit;
    }
 
    @Override
    public String toString() {
        return "CurrentAccount [over_draft_limit=" + over_draft_limit + ", over_draft_limit_used=" + over_draft_limit_used + 
                ", accountBalance=" + accountBalance + ", getAccountNumber()=" + getAccountNumber() + 
                ", getAccountName()=" + getAccountName() + ", getAccountBalance()=" + getAccountBalance() + 
                ", getAccountType()=" + getAccountType() + "]";
    }
}