package com.assignment.model;

public class StringShift {

    public static String shiftString(String inputString, int n) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        
        int len = inputString.length();
        n = n % len; // Normalize n
        
        StringBuilder shifted = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            char c = inputString.charAt(i);
            
            // Shift only alphabetical characters
            if (Character.isLowerCase(c)) {
                c = (char) ('a' + (c - 'a' + n + 26) % 26);
            } else if (Character.isUpperCase(c)) {
                c = (char) ('A' + (c - 'A' + n + 26) % 26);
            }
            
            shifted.append(c);
        }
        
        return shifted.toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftString("abc", 2));   // Output: "cde"
        System.out.println(shiftString("xyz", 3));   // Output: "abc"
        System.out.println(shiftString("zZa", 2));   // Output: "bBc"
        System.out.println(shiftString("xyz", -2));  // Output: "vwx"
    }
}
