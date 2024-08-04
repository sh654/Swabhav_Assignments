package com.assignment.model;

import java.util.Scanner;
public class RideBillCalculator {
public static void main(String args[]) {
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter your Height (cm's): ");
	
	int height = scanner.nextInt();
	
	System.out.println("");
	System.out.println("Enter your Age: ");
	int age = scanner.nextInt();
	scanner.nextLine();
	int bill = 0;
		
	if(height> 120) {
		
		System.out.println("Can Ride");
		
		if(age<12) {
			bill+=5;
			System.out.println("$"+bill);
			System.out.print("Do you want photos? (yes/no): ");
		    String userResponse = scanner.nextLine();
			if(userResponse.equals("yes")) {
				bill+=3;
				System.out.println("Total Bill is $"+bill);
			}
			else {
				System.out.println("Total Bill is $"+bill);
			}
			
		}else if((12<=age)&&(age<18)) {
			
			bill+=7;
			System.out.println("$"+bill);
			
			System.out.println("$"+bill);
			System.out.print("Do you want photos? (yes/no): ");
		    String userResponse = scanner.nextLine();
			if(userResponse.equals("yes")) {
				bill+=3;
				System.out.println("Total Bill is $"+bill);
			}
			else {
				System.out.println("Total Bill is $"+bill);
			}

			
		}	
		else if((age>=18) && (age<45)) {
			
			bill+=12;
			System.out.println("$"+bill);
			
			System.out.println("$"+bill);
			System.out.print("Do you want photos? (yes/no): ");
		    String userResponse = scanner.nextLine();
			if(userResponse.equals("yes")) {
				bill+=3;
				System.out.println("Total Bill is $"+bill);
			}
			else {
				System.out.println("Total Bill is $"+bill);
			}
			
		} 	
		else if ((age>=45)&&(age>=55)) {
				
			bill+=0;
			System.out.println("$"+bill);
			
			System.out.println("$"+bill);
			System.out.print("Do you want photos? (yes/no): ");
		    String userResponse = scanner.nextLine();
			if(userResponse.equals("yes")) {
				bill+=3;
				System.out.println("Total Bill is $"+bill);
			}
			else {
				System.out.println("Total Bill is $"+bill);
			}
	
		} 
		
		else {
				System.out.println("you Dont fall in valid age category");
		}
		
	} 
	else {
		System.out.println("Cant Ride! ");	
	}	
}

}
