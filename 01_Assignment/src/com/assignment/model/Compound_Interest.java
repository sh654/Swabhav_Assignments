package com.assignment.model;

import java.util.*;
public class Compound_Interest {

	public static double calculateCompoundInterest(double principal, double rate, int time, int n) {
		
		double rateDecimal = rate/100.0;
		
		double amount = principal * Math.pow(1 + rateDecimal / n, n * time);
		
		
		return amount - principal;
	}
	public static void main(String args[]) {
		Scanner object = new Scanner(System.in);
		System.out.println("Enter value for principal: ");
		double principal = object.nextDouble();
		System.out.println("Enter value for rate: ");
		double rate = object.nextDouble();
		System.out.println("Enter value for time: ");
		int time = object.nextInt();
		System.out.println("Enter value for number of time interest compounded: ");
		int n = object.nextInt();
		
		double compoundInterest = calculateCompoundInterest(principal, rate, time, n);
System.out.println("the compound interest for a principal of $ "+ principal+" at annual rate of :"+ rate+"% for"+time+"years compounded "+n+" time per year is"+compoundInterest);
		
	}
}
