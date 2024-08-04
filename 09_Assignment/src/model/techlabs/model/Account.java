package model.techlabs.model;
public class Account {
    protected int accno;
    protected String name;
    protected double balance;

    public Account(int accno, String name, double balance) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
    }

    public void credit(double amount) {
        balance += amount;
        System.out.println("Amount credited: " + amount);
        System.out.println("New balance: " + balance);
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount debited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void display() {
        System.out.println("Account No: " + accno);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}