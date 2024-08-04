package com.assignment.model;
import java.util.Scanner;
public class SecondLargest {
	public static void returnSecondLargest(int[] array) {
		if (array.length < 2) {
            System.out.println("Array size must be at least 2 to find the second largest element.");
            return;
        }
        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                secondMax = firstMax; // Current firstMax becomes secondMax
                firstMax = array[i];  // Update firstMax to current element
            } else if (array[i] > secondMax && array[i] != firstMax) {
                secondMax = array[i]; // Update secondMax if current element is greater than current secondMax
            }
        }
        if (secondMax == 0) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("Second largest element is: " + secondMax);
        }
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Size of Array: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter Elements of Array: ");
		for(int i=0; i<size; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Your array Elements are");
		for(int i=0; i<size; i++) {
			System.out.print(array[i] + " ");
		}	
		returnSecondLargest(array);
	}

}
