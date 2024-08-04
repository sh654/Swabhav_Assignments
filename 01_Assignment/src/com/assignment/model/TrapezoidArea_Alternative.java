package com.assignment.model;

public class TrapezoidArea_Alternative {
public static void main(String args[]) {
		
		double base1 = Double.parseDouble(args[0]);
		System.out.println("Enter value of base1 : " +base1);
		double base2= Double.parseDouble(args[1]);
		System.out.println("Enter value of base2 : " +base2);
		double height = Double.parseDouble(args[2]);
		System.out.println("Enter value of height : " +height);
		double area = trapezoidArea(base1, base2, height);
		
		System.out.println("Area of Trapezoid: "+area);
	}
	
	public static double trapezoidArea(double base1, double base2, double height) {
		return  0.5 * (base1 + base2) * height;
	}
}
