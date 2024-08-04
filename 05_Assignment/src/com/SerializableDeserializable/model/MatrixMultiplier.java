package com.SerializableDeserializable.model;

import java.util.Scanner;

public class MatrixMultiplier {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] array1;
		int[][] array2;
		int[][] sumArray;
		
		// first matrix init
		System.out.println("Enter size first of rows: ");
		int row1 = scanner.nextInt();
		
		System.out.println("Enter size first of columns: ");
		int column1 = scanner.nextInt();
		
		array1 = new int[row1][column1];
		
		System.out.println("Enter first array elements :");
		for(int i = 0; i < row1; i++) {
			for(int j = 0; j < column1; j++) {
				System.out.println("Enter row " + i + " and column " + j + " element");
				array1[i][j] = scanner.nextInt();
			}
		}
		
		// second matrix init
		
		System.out.println("Enter size second of rows: ");
		int row2 = scanner.nextInt();
		
		System.out.println("Enter size second of columns: ");
		int column2 = scanner.nextInt();
		
		array2 = new int[row2][column2];
		
		System.out.println("Enter second array elements :");
		for(int i = 0; i < row2; i++) {
			for(int j = 0; j < column2; j++) {
				System.out.println("Enter row " + i + " and column " + j + " element");
				array2[i][j] = scanner.nextInt();
			}
		}
		
		if(column1 != row2) {
			System.out.println("Can't add different dimension array");
		} else {
			sumArray = new int[row1][column2];
			for(int i = 0; i < row1; i++) {
				for(int j = 0; j < column1; j++) {
					for(int k = 0; k < column2; k++) {
						sumArray[i][k] += array1[i][j] * array2[j][k]; 		
					}
				};
			}
			
			System.out.println("Printing array: ");
			for(int i = 0; i < row1; i++) {
				for(int j = 0; j < column2; j++) {
					System.out.print(sumArray[i][j] + "\t");
				}
				System.out.println("");
			}
			
		}
	
		scanner.close();
	}
}
