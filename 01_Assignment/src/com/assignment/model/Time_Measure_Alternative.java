package com.assignment.model;

public class Time_Measure_Alternative {
	
	public static void main(String args[]) {
		
		System.out.println("Enter Minutes : ");
		int minutes = Integer.parseInt(args[0]);
		
		int hour = minutes/60;
		int remaining_minutes = minutes %60;
		System.out.println("For Minutes: "+minutes+" is : "+hour+" hours and " +remaining_minutes+" minutes");
	}
}
