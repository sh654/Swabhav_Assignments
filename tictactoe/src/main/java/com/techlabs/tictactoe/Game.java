package com.techlabs.tictactoe;

public class Game {
    private Player currentPlayer;
    private Player[] players;
    private Board board;
    private ResultAnalyzer analyzer;
    private ResultType result;

    public Game(Player[] players, Board board, ResultAnalyzer analyzer) {
        this.players = players;
        this.board = board;
        this.analyzer = analyzer;
        this.currentPlayer = players[0];
        this.result = ResultType.PROGRESS;

        players[0].setMark(MarkType.X);
        players[1].setMark(MarkType.O);
    }

    public void play(int loc) throws CellAlreadyMarkedException {
        if (result == ResultType.PROGRESS) {
            board.setCellMark(loc, currentPlayer.getMark());
            result = analyzer.analyzeResult();
            if (result == ResultType.PROGRESS) {
                switchCurrentPlayer();
            }
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ResultType getResult() {
        return result;
    }
}

