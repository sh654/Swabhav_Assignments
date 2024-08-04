package com.assignment.model;
import java.util.Scanner;
public class CurrencyDomination {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter withdrawal amount: ");
		Scanner scanner = new Scanner(System.in);
		int amount = scanner.nextInt();
		int amount_2000 =0;  
		int amount_500 =0;  
		int amount_200 =0;
		int amount_100 =0;
		
		if(amount>50000) {
			System.out.println("");
		} else if(amount % 100 !=0){
			System.out.println("Error enter multiple of 100");
		} else {
			amount_2000 = amount/2000;
			amount = amount % 2000;
			if( amount_2000 !=0)
				System.out.println("Two Thousand: " +amount_2000);
			amount_500 = amount/500;
			amount = amount % 500;
			if( amount_500 !=0)
				System.out.println("Five Hundred: "+amount_500);
			amount_200 = amount/200;
			amount = amount % 200;
			if(amount_200 !=0) 
				System.out.println("Two hundred: "+amount_200);
			amount_100 = amount/100;
			amount = amount % 100;
			if(amount_100 !=0)
				System.out.println("Two hundred: "+amount_100);
		}	
	}
}
