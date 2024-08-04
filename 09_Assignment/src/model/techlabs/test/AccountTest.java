package model.techlabs.test;

import java.util.Scanner;
import model.techlabs.model.*;
public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1) Create Account");
            System.out.println("2) Debit");
            System.out.println("3) Credit");
            System.out.println("4) Display Account Type");
            System.out.println("5) Display Balance Savings Account only");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accno = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Account Type (1 for Current, 2 for Savings): ");
                    int type = scanner.nextInt();
                    if (type == 1) {
                        account = new CurrentAccount(accno, name, balance);
                    } else if (type == 2) {
                        account = new SavingsAccount(accno, name, balance);
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to debit: ");
                        double debitAmount = scanner.nextDouble();
                        account.debit(debitAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to credit: ");
                        double creditAmount = scanner.nextDouble();
                        account.credit(creditAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.display();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 5:
                    if (account != null && account instanceof SavingsAccount) {
                        System.out.println("Balance: " + ((SavingsAccount) account).getBalance());
                    } else if (account != null) {
                        System.out.println("This option is only for Savings Account.");
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
