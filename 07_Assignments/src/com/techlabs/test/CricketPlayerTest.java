package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.CricketPlayer;

public class CricketPlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of Players: ");
		int size = scanner.nextInt();
		CricketPlayer players[] = new CricketPlayer[size]; // Arrays of Object
		
		
		for(int i=0; i< players.length; i++) {
			System.out.println("Enter Id of player: ");
			int playerId = scanner.nextInt();
			System.out.println("Enter name of Player: ");
			String playerName = scanner.next();
			System.out.println("Enter number of Matches: ");
			int numberOfMatches = scanner.nextInt();
			System.out.println("Enter runs of players: ");
			int runs = scanner.nextInt();
			System.out.println("Enter number of wickets : ");
			int numberOfWickets = scanner.nextInt();
			players[i] = new CricketPlayer(playerId,  playerName,  numberOfMatches, runs, numberOfWickets);
		}
		
		for(int i=0; i<players.length; i++) {
			players[i].display();
			System.out.println("Average: " +players[i].calculateAverage());
			
		}
		
		CricketPlayer maxAveragePlayer = CricketPlayer.getMaximumAveragePlayer(players);

        if (maxAveragePlayer != null) {
            System.out.println("Player with maximum average runs per match:");
            maxAveragePlayer.display();
        } else {
            System.out.println("No players found.");
        }
		
		/*
		System.out.println(player12
		.getPlayerId());
		System.out.println(player1.getPlayerName());
		System.out.println(player1.getNumberOfMatches());
		System.out.println(player1.getRuns());
		System.out.println(player1.getNumberOfWickets());
		*/
		
//		player1.display();
		//System.out.println("Average of "+player1.getPlayerName()+" whose runs are "+player1.getRuns()+" in matches "+player1.getNumberOfMatches()+"is : "+player1.calculateAverage());
		
		
	}

}
