package com.assignment.model;

import java.util.*;
public class Time_Measure {
	
	public static void time_measure() {
		Scanner object = new Scanner(System.in);
		
		System.out.println("Enter Minutes : ");
		int minutes = object.nextInt();
		
		int hour = minutes/60;
		int remaining_minutes = minutes %60;
		System.out.println("For Minutes: "+minutes+" is : "+hour+" hours and " +remaining_minutes+" minutes");
		
	}
	
	public static void main(String args[]) {
		
		time_measure();
	}
}
