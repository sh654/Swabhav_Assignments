package com.assignment.model;

import java.util.Scanner;

public class SortedSquares {
    
	static int[] sortedSquares(int[] array) {
		int[] sortedSquares = new int[array.length];
		
		int[] arraycp = array;
		
		int left = 0;
		int right = array.length - 1;
		int position = array.length -1;
		
		for(int i=0; i<arraycp.length; i++) {
			arraycp[i] = (int) Math.pow(arraycp[i], 2);
		}
		
		while(left<=right) {
		  
		  if(array[left]>array[right]) {
			  sortedSquares[position] = array[left];
			  position--;
			  left++;
		  } else {
			  sortedSquares[position] = array[right];
			  position --;
			  right--;
		  }
		}
		return sortedSquares;
	} 
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter size of yiur array: ");
    	int size = scanner.nextInt();
    	int[] array = new int[size];
    	
    	System.out.println("element of array: ");
    	for(int i=0; i<size; i++) {
    		
    		array[i]=scanner.nextInt();
    	}
    	
    	//print
    	for(int i=0; i<size; i++) {
    		System.out.println(array[i] + " ");
    	}
    	
    	
        int[] sortedSquaresArray = sortedSquares(array);
        
        System.out.println("Element of sorted Square Array: ");
        for(int i=0; i<sortedSquaresArray.length; i++) {
        	System.out.print(sortedSquaresArray[i]+ " ");
        }
        
        scanner.close();
        
        // Output: 4 9 9 49 121
    }
    

}
