package com.techlabs.model;
import java.util.Random;
import java.util.Scanner;

public class RefactoredPigGame {
	private Scanner scanner;
	private Random random;
	private int totalScore;
	private int turnScore;
	private int turnCount;
	private boolean flag;
	public RefactoredPigGame() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
		this.totalScore = 0;
		this.turnScore = 0;
		this.turnCount = 1;
	}
	public void startGame() {
		System.out.println("Let's Play PIG!");
		while(totalScore <= 20) {
			System.out.println("\nTURN " + turnCount + "\n");
			flag = false;
			turnScore = 0;
			this.turn();
			turnCount++;
		}
		System.out.println("You have finished in " + (turnCount - 1) + " turns!");
		System.out.println("Game Over");
	}
	
	private void turn() {
		while(!flag) {
			System.out.println("Roll or hold ? (r/h): ");
			String choice = scanner.next().toLowerCase();
			char firstChar = choice.charAt(0);
			checkChoice(firstChar);
		}
		scanner.close();
	}
	private void checkChoice(char firstChar) {
		switch (firstChar) {
		case 'h':
			this.hold();
			break;
		case 'r':
			this.roll();
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	private void roll() {
		int die = random.nextInt(6) + 1;
		System.out.println("Die: " + die);
		if(die == 1) {
			System.out.println("Score turns to zero");
			
			turnScore = 0;
			return;
		}
		turnScore += die;
		if((totalScore + turnScore) >= 20) this.hold();
	}
	
	private void hold() {
		totalScore += turnScore;
		flag = true;
		System.out.println("Score for turn " + turnScore);
		System.out.println("Total score " + totalScore);
	}
	}
