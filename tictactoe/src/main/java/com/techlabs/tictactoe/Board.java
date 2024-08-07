package com.techlabs.tictactoe;

public class Board {
    private Cell[] cells;

    public Board() {
        cells = new Cell[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setCellMark(int loc, MarkType mark) throws CellAlreadyMarkedException {
        cells[loc].setMark(mark);
    }

    public MarkType getCellMark(int loc) {
        return cells[loc].getMark();
    }
}
