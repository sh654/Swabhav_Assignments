package com.assignment.model;
import java.util.Random;
import java.util.Scanner;
public class Number_Guessing {
	 public static void main(String[] args) {
		  Random rand = new Random();
		  int randomNumber = rand.nextInt(100) + 1;
		  
		  System.out.println("Random Generated Number is "+ randomNumber);
		  int lives =5;
		  
		  Scanner scanner = new Scanner(System.in);
		  while (lives > 0) {
		   lives--;
		   System.out.println("Guess a number? ");
		   int guess = scanner.nextInt();
		   
		   if(guess > randomNumber) {
		    System.out.println("sorry the number is too high");
		   }else if(guess < randomNumber) {
		    System.out.println("sorry the number is too low");
		   }else {
		    System.out.println("You won, You guessed it right in  "+ (5 - lives) + " attempt");
		   }
		   
		   if(lives == 0) {
		    System.out.println("Do you want to play the game again: yes/no");
		    String userAnswer = scanner.next().toLowerCase();
		    if (userAnswer.equals("yes")) {
		     lives = 5;
		     randomNumber = rand.nextInt(100) + 1;
		     System.out.println("Random Generated Number is "+ randomNumber);
		    }
		   }
		  }
		  scanner.close();
		 }
}
