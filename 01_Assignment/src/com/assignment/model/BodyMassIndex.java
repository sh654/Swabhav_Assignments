package com.assignment.model;

import java.util.*;
public class BodyMassIndex {
	
	
	private static void calculateBMI() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter weight in Kilogram: ");
	    float weight = scanner.nextFloat();
	    System.out.print("Enter Height in Meters: ");
	    float height = scanner.nextFloat();

	    float bmi = weight / (height * height);
	    System.out.println("The BMI is " + bmi + " kg/m²");
	}
	
	
	public static void main(String args[]) {
		
		calculateBMI();
	}
}
