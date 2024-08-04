package com.techlabs.model;

public class CricketPlayer {

	private int playerId;
	private String playerName;
	private int numberOfMatches;
	private int runs;
	private int numberOfWickets;
	
	public CricketPlayer(int playerId,String playerName, int numberOfMatches,int runs,int numberOfWickets) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.numberOfMatches = numberOfMatches;
		this.runs = runs;
		this.numberOfWickets = numberOfWickets;
		
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public void setNumberOfWickets(int numberOfWickets) {
		this.numberOfWickets = numberOfWickets;
	}
	
	public int getPlayerId() {
		return this.playerId;
	}
	public int getNumberOfMatches() {
		return this.numberOfMatches;
	}
	public String getPlayerName() {
		return this.playerName;
	}
	public int getRuns() {
		return this.runs;
	}
	public int getNumberOfWickets() {
		return this.numberOfWickets;
	}
	
	public void display() {
		System.out.println("Player id: "+ this.playerId);
		System.out.println("Player id: "+ this.playerName);
		System.out.println("Player id: "+ this.numberOfMatches);
		System.out.println("Player id: "+ this.runs);
		System.out.println("Player id: "+ this.numberOfWickets);
		
	}
	private float average;
	 public float calculateAverage() {
	        if (numberOfMatches > 0) {
	            average = (float) runs / numberOfMatches;
	        } else {
	            average = 0;
	        }
	        return average;
	    }
	
	public static CricketPlayer getMaximumAveragePlayer(CricketPlayer[] players) {
		CricketPlayer maxAveragePlayer = players[0]; //player id
		float maxAverage = players[0].calculateAverage(); // max value of the above id
		
		if(players.length ==0 || players == null) {
			System.out.println("empty");
		} else {
			for(int i=0; i<players.length; i++) {
				float currentAverage = players[i].calculateAverage();
				
				if(currentAverage > maxAverage) {
					maxAverage = currentAverage;
					maxAveragePlayer = players[i];
				}
			}
			
		}
		return maxAveragePlayer;	
	}
	
}
