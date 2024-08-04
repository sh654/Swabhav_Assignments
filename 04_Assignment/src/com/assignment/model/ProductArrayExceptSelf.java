package com.assignment.model;
import java.util.Scanner;
public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = 1;
        }
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return output;
    }
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int size = scanner.nextInt();
        int[] inputArray = new int[size];
        System.out.println("Enter Elements of Array: ");
        for(int i=0; i<size; i++) {
        	inputArray[i] = scanner.nextInt();
        }
        int[] result = productExceptSelf(inputArray);
        System.out.print("Input array: ");
        for (int num : inputArray) {
            System.out.print(num + " ");
        } 
        System.out.println(); 
        System.out.print("Output array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
