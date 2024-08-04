package com.techlabs.test;

import com.techlabs.model.PigGame;

public class PigGameTest {
    public static void main(String[] args) {
    	        PigGame game = new PigGame();
    	        game.playGame();
    	    
        testRollDie();
        testGamePlay();
    }

    private static void testRollDie() {
        PigGame game = new PigGame();
        int roll = game.rollDie();
        assert roll >= 1 && roll <= 6 : "Dice roll should be between 1 and 6";
    }

    private static void testGamePlay() {
        PigGame game = new PigGame();
        game.playGame();
        assert game.getTotalScore() >= 20 : "Total score should be at least 20 after game play";
    }
}
