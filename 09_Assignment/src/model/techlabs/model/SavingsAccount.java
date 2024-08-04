package model.techlabs.model;
public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(int accno, String name, double balance) {
        super(accno, name, balance);
    }

    @Override
    public void debit(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Amount debited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Cannot debit. Minimum balance should be maintained.");
        }
    }
    
    @Override
    public void credit(double amount) {
    	if(amount<= 0) {
    		System.out.println("Enter Valid amount");
    		return;
    	} 	
    	balance+= amount;
    	System.out.println("Amount Credited: " + amount);
        System.out.println("New balance: " + balance);
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Account Type: Savings");
        System.out.println("Minimum Balance: " + MIN_BALANCE);
    }
    public double getBalance() {
        return balance;
    }
}