package com.techlabs.model;

import java.util.*;
public class PigGame {
    private int totalScore;
    private int turnScore;
    private int turnCount;
    private final Scanner scanner;
    private final Random random;

    public PigGame() {
        this.totalScore = 0;
        this.turnScore = 0;
        this.turnCount = 1;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void playGame() {
        System.out.println("Let's Play PIG!");

        while (totalScore < 20) {
            turnScore = 0;
            boolean turnOverFlag = false;

            System.out.println("\nTURN " + turnCount + "\n");

            while (!turnOverFlag) {
                System.out.println("Roll or hold ? (r/h): ");
                char choice = scanner.next().toLowerCase().charAt(0);

                if (choice == 'r') {
                    int die = rollDie();
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        System.out.println("Score turns to zero");
                        turnOverFlag = true;
                        turnScore = 0;
                    } else {
                        turnScore += die;
                        if (turnScore > 20) {
                            totalScore += turnScore;
                            System.out.println("Score for turn " + turnScore);
                            System.out.println("Total score " + totalScore);
                            turnOverFlag = true;
                        }
                    }
                } else if (choice == 'h') {
                    totalScore += turnScore;
                    System.out.println("Score for turn " + turnScore);
                    System.out.println("Total score " + totalScore);
                    turnOverFlag = true;
                } else {
                    System.out.println("Invalid input");
                }
            }
            turnCount++;
        }
        System.out.println("You have finished in " + (turnCount - 1) + " turns!");
        System.out.println("Game Over");
        scanner.close();
    }

    public int rollDie() {
        return random.nextInt(6) + 1;
    }

    public int getTotalScore() {
        return totalScore;
    }

   
}
