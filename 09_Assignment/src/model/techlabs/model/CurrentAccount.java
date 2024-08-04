package model.techlabs.model;

public class CurrentAccount extends Account {
    private static final double OVER_DRAFT_LIMIT = 1000;

    public CurrentAccount(int accno, String name, double balance) {
        super(accno, name, balance);
    }

    @Override
    public void debit(double amount) {
        if (balance + OVER_DRAFT_LIMIT >= amount) {
            balance -= amount;
            System.out.println("Amount debited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public void credit(double amount) {
        if (balance < -OVER_DRAFT_LIMIT) {
            System.out.println("Cannot deposit. Overdraft limit exceeded.");
        } else {
            super.credit(amount);
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: " + OVER_DRAFT_LIMIT);
    }
}
