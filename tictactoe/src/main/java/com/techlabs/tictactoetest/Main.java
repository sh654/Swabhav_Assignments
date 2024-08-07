package com.techlabs.tictactoetest;

import java.util.Scanner;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.CellAlreadyMarkedException;
import com.techlabs.tictactoe.Game;
import com.techlabs.tictactoe.Player;
import com.techlabs.tictactoe.ResultAnalyzer;
import com.techlabs.tictactoe.ResultType;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player[] players = {player1, player2};

        Board board = new Board();
        ResultAnalyzer analyzer = new ResultAnalyzer(board);
        Game game = new Game(players, board, analyzer);

        while (game.getResult() == ResultType.PROGRESS) {
            System.out.println("Current Board:");
            printBoard(board);

            System.out.println(game.getCurrentPlayer().getName() + "'s turn. Enter position (0-8): ");
            int position = scanner.nextInt();

            try {
                game.play(position);
            } catch (CellAlreadyMarkedException e) {
                System.out.println(e.getMessage());
            }
        }

        printBoard(board);
        if (game.getResult() == ResultType.WIN) {
            System.out.println(game.getCurrentPlayer().getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    private static void printBoard(Board board) {
        for (int i = 0; i < 9; i++) {
            System.out.print(board.getCellMark(i) + " ");
            if (i % 3 == 2) System.out.println();
        }
    }
}

