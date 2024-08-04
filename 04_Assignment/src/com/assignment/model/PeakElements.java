package com.assignment.model;
import java.util.Scanner;
public class PeakElements {
    public static int[] findPeakElements(int[] arr) {
        int n = arr.length;
        int[] tempPeaks = new int[n]; // Temporary array to store peak elements one by one
        int peakCount = 0;
        // Edge case if array has only one element it is a peak
        if (n == 1) {
            return new int[] {arr[0]};
        }
        // Check if the first element is a peak
        if (arr[0] >= arr[1]) {
            tempPeaks[peakCount++] = arr[0];
        }
        
        // Check the middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                tempPeaks[peakCount++] = arr[i];
            }
        }
        
        // Check if the last element is a peak
        if (arr[n - 1] >= arr[n - 2]) {
            tempPeaks[peakCount++] = arr[n - 1];
        }
        
        // Create the result array with exact size
        int[] peaks = new int[peakCount];
        System.arraycopy(tempPeaks, 0, peaks, 0, peakCount);
        
        return peaks;
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int size =scanner.nextInt();
        int[] array = new int[size];
        
        for(int i=0; i<size; i++) {
        	array[i] = scanner.nextInt();
        }
        int[] peakElements = findPeakElements(array);
        for (int peak : peakElements) {
            System.out.println(peak);  // Output: 5
        }
    }
}
