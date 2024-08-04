package com.techlabs.facade.model;


public class Board {
    private char[][] board;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j]);
                if (j < columns - 1) System.out.print("|");
            }
            System.out.println();
            if (i < rows - 1) {
                for (int k = 0; k < columns * 2 - 1; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < columns && board[row][col] == ' ') {
            return true;
        }
        return false;
    }

    public void makeMove(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
        }
    }

    public boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < rows; i++) {
            if (checkRow(board[i], symbol)) {
                return true;
            }
        }
        for (int j = 0; j < columns; j++) {
            if (checkColumn(j, symbol)) {
                return true;
            }
        }
        // Check diagonals only if rows and columns are equal
        if (rows == columns) {
            if (checkDiagonal(symbol) || checkAntiDiagonal(symbol)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkRow(char[] row, char symbol) {
        for (char c : row) {
            if (c != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int colIndex, char symbol) {
        for (int i = 0; i < rows; i++) {
            if (board[i][colIndex] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char symbol) {
        for (int i = 0; i < rows; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(char symbol) {
        for (int i = 0; i < rows; i++) {
            if (board[i][columns - i - 1] != symbol) {
                return false;
            }
        }
        return true;
    }
}
