package com.techlabs.test;
 
import java.util.Scanner;
 
import com.techlabs.exception.MinBalanceException;
import com.techlabs.exception.OverDraftLimitExceedeException;
import com.techlabs.model.BankAccountApp;
import com.techlabs.model.CurrentAccount;
import com.techlabs.model.SavingsAccount;
 
public class BankAccountTest {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
 
        BankAccountApp[] bankUsers = null;
        do {
            System.out.println("Welcome, choose any option:");
            System.out.println("1) Create Account");
            System.out.println("2) Debit Money");
            System.out.println("3) Credit Money");
            System.out.println("4) Display Record");
            System.out.println("5) Exit");
 
            int choice = scanner.nextInt();
            try {
                switch (choice) {
 
                    case 1:
                        System.out.println("Enter Number of Accounts to be created: ");
                        int size = scanner.nextInt();
                        int count = 0;
                        bankUsers = new BankAccountApp[size]; // Array of Objects
                        while (count < size) {
                            System.out.println("Account Number: ");
                            long accountNumber = scanner.nextLong();
                            System.out.println("Account Holder Name: ");
                            String accountName = scanner.next();
                            System.out.println("Account Balance: ");
                            double accountBalance = scanner.nextDouble();
                            System.out.println("Account type \n 1) Savings \n 2) Current");
                            String accountType = scanner.next();
 
                            switch (accountType.toLowerCase()) {
                                case "1":
                                case "savings":
                                    System.out.println("Enter your Min Balance: ");
                                    double minBalance = scanner.nextDouble();
                                    BankAccountApp bankUser = new SavingsAccount(accountNumber, accountName, accountBalance, "Savings", minBalance);
                                    bankUsers[count] = bankUser;
                                    count++;
                                    break;
 
                                case "2":
                                case "current":
                                    System.out.println("Enter your over draft limit: ");
                                    double over_draft_limit = scanner.nextDouble();
                                    BankAccountApp bankUserC = new CurrentAccount(accountNumber, accountName, accountBalance, "Current", over_draft_limit);
                                    bankUsers[count] = bankUserC;
                                    count++;
                                    break;
 
                                default:
                                    System.out.println("Choose only above 2 options");
                                    break;
                            }
                        }
                        break;
 
                    case 2:
                        debitAmount(scanner, bankUsers);
                        break;
 
                    case 3:
                        creditAmount(scanner, bankUsers);
                        break;
 
                    case 4:
                        printDetails(bankUsers);
                        break;
 
                    case 5:
                        System.out.println("Thank you for using the app");
                        isExit = true;
                        break;
 
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (MinBalanceException e) {
                System.out.println(e.getMessage());
            } catch (OverDraftLimitExceedeException e) {
                System.out.println(e.getMessage());
            }
        } while (!isExit);
        scanner.close();
    }
 
    private static void printDetails(BankAccountApp[] bankUsers) {
        for (BankAccountApp account : bankUsers) {
            System.out.println(account);
        }
    }
 
    private static void debitAmount(Scanner scanner, BankAccountApp[] bankUsers) throws MinBalanceException, OverDraftLimitExceedeException {
        System.out.println("Enter your account Number: ");
        long accountNo = scanner.nextLong();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        for (BankAccountApp account : bankUsers) {
            if (account.getAccountNumber() == accountNo) {
                try {
                    account.debit(amount);
                } catch (MinBalanceException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Do you want to continue with the transaction and allow the balance to go negative? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        if (account instanceof SavingsAccount) {
                            ((SavingsAccount) account).forceDebit(amount);
                        } else {
                            System.out.println("Negative balance handling is not supported for this account type.");
                        }
                    }
                } catch (OverDraftLimitExceedeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Do you want to use the overdraft limit? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        System.out.println("Enter overdraft limit to be used: ");
                        double overdraftLimit = scanner.nextDouble();
                        if (account instanceof CurrentAccount) {
                            ((CurrentAccount) account).setOverDraftLimit(overdraftLimit);
                            ((CurrentAccount) account).debit(amount);
                        } else {
                            System.out.println("Overdraft handling is not supported for this account type.");
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }
 
    private static void creditAmount(Scanner scanner, BankAccountApp[] bankUsers) throws OverDraftLimitExceedeException {
        System.out.println("Enter your account number: ");
        long accountNO = scanner.nextLong();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
 
        for (BankAccountApp account : bankUsers) {
            if (account.getAccountNumber() == accountNO) {
                try {
                    account.credit(amount);
                    System.out.println("Credited successfully. New balance: " + account.getAccountBalance());
                } catch (OverDraftLimitExceedeException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }
}