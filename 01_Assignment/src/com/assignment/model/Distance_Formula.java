package com.assignment.model;

import java.util.*;
public class Distance_Formula {

	public static double distanceFormula(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	
	public static void main(String args[]) {
		Scanner object = new Scanner(System.in);
		System.out.println("Enter value of x1: ");
		double x1 = object.nextDouble();
		System.out.println("Enter value of x2: ");
		double x2 = object.nextDouble();
		System.out.println("Enter value of y1: ");
		double y1 = object.nextDouble();
		System.out.println("Enter value of y2: ");
		double y2 = object.nextDouble();
		
		double distance = distanceFormula(1.0, 2.0, 4.0, 6.0);
		System.out.println("The Distance Between the points ( " +x1+"," +y1+" ) and ( "+x2+" ,"+y2+") is : " +distance);
	}
}
