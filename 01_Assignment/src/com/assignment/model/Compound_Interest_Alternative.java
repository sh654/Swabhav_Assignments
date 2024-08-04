package com.assignment.model;

import java.util.Scanner;

public class Compound_Interest_Alternative {
public static double calculateCompoundInterest(double principal, double rate, int time, int n) {
		
		double rateDecimal = rate/100.0;
		
		double amount = principal * Math.pow(1 + rateDecimal / n, n * time);
		
		
		return amount - principal;
	}
	public static void main(String args[]) {
		
		System.out.println("Enter value for principal: ");
		double principal = Double.parseDouble(args[0]);
		System.out.println("Enter value for rate: ");
		double rate = Double.parseDouble(args[1]);
		System.out.println("Enter value for time: ");
		int time = Integer.parseInt(args[2]);
		System.out.println("Enter value for number of time interest compounded: ");
		int n = Integer.parseInt(args[3]);
		
		double compoundInterest = calculateCompoundInterest(principal, rate, time, n);
		
System.out.println("the compound interest for a principal of $ "+ principal+" at annual rate of :"+ rate+"% for"+time+"years compounded "+n+" time per year is "+compoundInterest);
		
	}
}
