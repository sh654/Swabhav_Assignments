package com.techlabsPrototype.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlabs.Prototype.model.CurrentAccount;
import com.techlabs.Prototype.model.IAccount;
import com.techlabs.Prototype.model.SavingAccount;


public class AccountTest {

	public static List<IAccount> accounts = new ArrayList<>();
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Saving Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. View Balance");
            System.out.println("4. Credit");
            System.out.println("5. Debit");
            System.out.println("6. Clone Account");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createSavingAccount(scanner);
                    break;
                case 2:
                    createCurrentAccount(scanner);
                    break;
                case 3:
                    viewBalance(scanner);
                    break;
                case 4:
                    creditAmount(scanner);
                    break;
                case 5:
                    debitAmount(scanner);
                    break;
                case 6:
                    cloneAccount(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createSavingAccount(Scanner scanner) {
        System.out.print("Enter account name: ");
        String accountName = scanner.next();
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter minimum balance: ");
        double minBalance = scanner.nextDouble();

        IAccount savingAccount = new SavingAccount(accountName, accountNumber, balance, minBalance);
        accounts.add(savingAccount);
        System.out.println("Saving Account created successfully.");
    }

    private static void createCurrentAccount(Scanner scanner) {
        System.out.print("Enter account name: ");
        String accountName = scanner.next();
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter draft limit: ");
        double draftLimit = scanner.nextDouble();

        IAccount currentAccount = new CurrentAccount(accountName, accountNumber, balance, draftLimit);
        accounts.add(currentAccount);
        System.out.println("Current Account created successfully.");
    }

    private static void viewBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        IAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void creditAmount(Scanner scanner) {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("Enter amount to credit: ");
        double amount = scanner.nextDouble();
        IAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.credit(amount);
            System.out.println("Amount credited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void debitAmount(Scanner scanner) {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();
        System.out.print("Enter amount to debit: ");
        double amount = scanner.nextDouble();
        IAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.debit(amount);
            System.out.println("Amount debited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void cloneAccount(Scanner scanner) {
        System.out.print("Enter account number to clone: ");
        long accountNumber = scanner.nextLong();
        IAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            IAccount clonedAccount = account.clone();
            accounts.add(clonedAccount);
            System.out.println("Cloned account created successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static IAccount findAccountByNumber(long accountNumber) {
        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
		
	}

