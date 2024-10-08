package com.techlabs.facade.test;

import java.util.Scanner;

import com.techlabs.facade.model.Game;

public class TicTacToeGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the Tic-Tac-Toe board: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        
        Game game = new Game(rows, columns);
        game.play();
        scanner.close();
	}
}
