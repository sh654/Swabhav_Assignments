package com.assignment.model;
import java.util.Scanner;
import java.util.Random;
public class PigGame {
public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	 int targetScore = 20;
     int totalScore = 0;
     int turnNumber = 1;
     while (totalScore < targetScore) {
         int turnScore = 0;
         boolean turnActive = true;
         System.out.println("TURN " + turnNumber);
         while (turnActive) {
             System.out.print("Roll or hold? (r/h): ");
             char choice = scanner.next().toLowerCase().charAt(0);
             if (choice == 'r') {
                 int die = random.nextInt(6) + 1;
                 System.out.println("Die: " + die);
                 if (die == 1) {
                     turnScore = 0;
                     turnActive = false;
                     System.out.println("Turn over. No score.");
                 } else {
                     turnScore += die;
                     System.out.println("Current turn score: " + turnScore);
                 }
             } else if (choice == 'h') {
                 totalScore += turnScore;
                 turnActive = false;
                 System.out.println("Turn over. Total score: " + totalScore);
             } else {
                 System.out.println("Invalid input. Please enter 'r' to roll or 'h' to hold.");
             }
         }
         turnNumber++;
     }

     System.out.println("Congratulations! You reached " + targetScore + " points in " + (turnNumber - 1) + " turns.");
     scanner.close();
}
}
