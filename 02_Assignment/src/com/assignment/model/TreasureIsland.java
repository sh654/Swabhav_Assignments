package com.assignment.model;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
public class TreasureIsland {
public static void main(String args []) {
	System.out.println("Welcome to Treasure IsLand your mission is to find treasure");
	Scanner scanner = new Scanner(System.in);
	System.out.println("left or right?");
	String direction = scanner.nextLine();
	if(direction.equals("left")) {			
		System.out.println("swim or wait?");
		String task = scanner.nextLine();
		if(task.equals("wait")) {	
			System.out.println("Whih Color Door: ");
			String door = scanner.nextLine();
			switch(door) {
			case "Yellow" :
				System.out.println("You win!");
				break;
			case "Red":
				System.out.println("burned by fire");
				break;
			case "Blue":
				System.out.println("Eaten by beasts \t Game Over.");
				break;
			default:
				System.out.println("Game Over");
			}
		} else{
			System.out.println("Attacked by trout Game Over");
		}
	}
	else {
		System.out.println("Fall into a hole Game Over.");
}

}
}
