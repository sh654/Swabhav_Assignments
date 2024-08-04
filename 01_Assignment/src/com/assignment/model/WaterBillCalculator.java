package com.assignment.model;

import java.util.Scanner;
public class WaterBillCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter units: ");
			int units_consumed = scanner.nextInt();
			int units_consumed_temp = units_consumed;
			final int meter_CHARGE = 75;
			int charge = 0;
			int total_waterbill = 0;
			
			while(units_consumed_temp > 0) {
				if (units_consumed_temp > 250) {
					charge = (units_consumed_temp - 250) * 20;
					units_consumed_temp = 250;
				}else if(units_consumed_temp > 100) {
					charge += (units_consumed_temp - 100) * 10;
					units_consumed_temp = 100;
				}else if(units_consumed_temp <= 100) {
					charge += units_consumed_temp * 5;
					break;
				}
			}
			
			total_waterbill = charge + meter_CHARGE;
			
			System.out.println("Total Water bill for " + units_consumed +" is "+ total_waterbill);
			
			scanner.close();
			
		}
	
}
