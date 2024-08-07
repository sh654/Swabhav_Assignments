package com.techlabs.tictactoe;

public class ResultAnalyzer {
    private Board board;
    private ResultType result;

    public ResultAnalyzer(Board board) {
        this.board = board;
        this.result = ResultType.PROGRESS;
    }

    public ResultType analyzeResult() {
        if (horizontalWinCheck() || verticalWinCheck() || diagonalWinCheck()) {
            return ResultType.WIN;
        } else if (board.isBoardFull()) {
            return ResultType.DRAW;
        } else {
            return ResultType.PROGRESS;
        }
    }

    private boolean horizontalWinCheck() {
        for (int i = 0; i < 3; i++) {
            if (board.getCellMark(i * 3) != MarkType.EMPTY &&
                board.getCellMark(i * 3) == board.getCellMark(i * 3 + 1) &&
                board.getCellMark(i * 3 + 1) == board.getCellMark(i * 3 + 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean verticalWinCheck() {
        for (int i = 0; i < 3; i++) {
            if (board.getCellMark(i) != MarkType.EMPTY &&
                board.getCellMark(i) == board.getCellMark(i + 3) &&
                board.getCellMark(i + 3) == board.getCellMark(i + 6)) {
                return true;
            }
        }
        return false;
    }

    private boolean diagonalWinCheck() {
        if (board.getCellMark(0) != MarkType.EMPTY &&
            board.getCellMark(0) == board.getCellMark(4) &&
            board.getCellMark(4) == board.getCellMark(8)) {
            return true;
        }
        if (board.getCellMark(2) != MarkType.EMPTY &&
            board.getCellMark(2) == board.getCellMark(4) &&
            board.getCellMark(4) == board.getCellMark(6)) {
            return true;
        }
        return false;
    }

    // Getters and Setters as required
    public ResultType getResult() {
        return result;
    }

    public Board getBoard() {
        return board;
    }
}
