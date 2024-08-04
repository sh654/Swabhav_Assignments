package com.techlabs.model;

import java.util.Scanner;

public class TestEnum {

	// An Enum class
	enum Day {
		SUNDAY,
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY;
	}

	// Driver class that contains an object of "day" and
	// main().
		Day day;

		// Constructor
		public TestEnum(Day day) { 
			this.day = day; 
		}

		// Prints a line about Day using switch
		public void dayIsLike()
		{
			switch (day) {
			case MONDAY:
				System.out.println("Mondays are bad.");
				break;
			case FRIDAY:
				System.out.println("Fridays are better.");
				break;
			case SATURDAY:
			case SUNDAY:
				System.out.println("Weekends are best.");
				break;
			default:
				System.out.println("Midweek days are so-so.");
				break;
			}
		}

		// Driver method
		public static void main(String[] args)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your Favourite Day: ");
			String str = scanner.next();
			TestEnum t1 = new TestEnum(Day.valueOf(str.toUpperCase()));
			t1.dayIsLike();
		}
	}

