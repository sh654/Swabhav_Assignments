package com.assignment.model;

import java.util.Scanner;

public class WaterBillCalculator1 {
	
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter units: ");
			int units = scanner.nextInt();
			final int meter_charge = 75;
			int charge = 0;
			int total_waterbill = 0;
			if(units <= 100) {
				charge = units * 5;
			}else {
				if(units <= 250) {
					charge = units * 10;
				}else {
					charge = units * 20;
				}
			}
			
			total_waterbill = charge + meter_charge;
			
			System.out.println("Total Water bill for " + units +" is "+ total_waterbill);
			
			scanner.close();
			
		}	
	}

