package com.assignment.model;



public class BodyMassIndexAlternate {
		
	public static void main(String args[]) {
		
		  System.out.print("Enter weight in Kilogram: ");
		  float weight = Float.parseFloat(args[0]);
		  System.out.print("Enter Height in Meters: ");
		  float height = Float.parseFloat(args[1]);

		  float bmi = weight / (height * height);
		  System.out.println("The BMI is " + bmi + " kg/m²");
	}
}
