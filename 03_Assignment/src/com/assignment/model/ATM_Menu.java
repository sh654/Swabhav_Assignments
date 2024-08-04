package com.assignment.model;
import java.util.Scanner;
public class ATM_Menu {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your balance: ");
		int balance = scanner.nextInt();
		System.out.println("Please choose an Option: ");
		int option;
		do{
			System.out.println("ATM Menu: ");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdrawal Money");
			System.out.println("4. Exit");
			System.out.println("Please choose an Option: ");
			option= scanner.nextInt(); // must option to declare value inside do to avoid Loops endlessly
			switch(option) {
			case 1: 
				System.out.println("Your bank balance is: $" +balance);
				break;
			case 2: 
				System.out.println("Enter amount to deposit: ");
				int deposit_money = scanner.nextInt();
				System.out.println("You have deposited $" +deposit_money + "Your bank balance is: $" +(balance =balance+deposit_money));
				break;
			case 3:
				System.out.println("Enter amount to withdraw: ");
				int withdraw_money = scanner.nextInt();
				if(withdraw_money > balance) {
					System.out.println("Please note your withrawal amount is exceding your current balance of : "+balance);
					System.out.println("To Proceed enter yes/no: ");
					String proceed = scanner.next().toLowerCase();
					
					
					if(proceed.equals("yes")) {
						System.out.println("Your Account Now is in Dept of $"+(balance=balance - withdraw_money));
					}
				} else
				System.out.println("You have withdraw $" +withdraw_money + "Your bank balance is: $" +(balance =balance-withdraw_money));
				
				break;
			case 4:
				System.out.println("Thank you for using the ATM. GoodBye!");
				break;
			default: 
				System.out.println("Enter valid Option");}}
		while(option<4);
	}
}