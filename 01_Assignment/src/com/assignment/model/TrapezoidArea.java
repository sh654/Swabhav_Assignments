package com.assignment.model;

import java.util.*;
public class TrapezoidArea {

	public static void main(String args[]) {
		
		Scanner object = new Scanner(System.in);
		System.out.println("Enter value of base1 : ");
		double base1 = object.nextDouble();
		System.out.println("Enter value of base2 : ");
		double base2= object.nextDouble();
		System.out.println("Enter value of height : ");
		double height = object.nextDouble();
		double area = trapezoidArea(base1, base2, height);
		
		System.out.println("Area of Trapezoid: "+area);
	}
	
	public static double trapezoidArea(double base1, double base2, double height) {
		return  0.5 * (base1 + base2) * height;
	}
}
