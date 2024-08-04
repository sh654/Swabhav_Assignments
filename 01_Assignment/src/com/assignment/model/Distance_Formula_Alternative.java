package com.assignment.model;


public class Distance_Formula_Alternative {
	public static double distanceFormula(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	
	public static void main(String args[]) {
		
		System.out.println("Enter value of x1: ");
		double x1 = Double.parseDouble(args[0]);
		System.out.println("Enter value of x2: ");
		double x2 = Double.parseDouble(args[1]);
		System.out.println("Enter value of y1: ");
		double y1 = Double.parseDouble(args[2]);
		System.out.println("Enter value of y2: ");
		double y2 = Double.parseDouble(args[3]);
		
		double distance = distanceFormula(1.0, 2.0, 4.0, 6.0);
		System.out.println("The Distance Between the points ( " +x1+"," +y1+" ) and ( "+x2+" ,"+y2+") is : " +distance);
	}
}
