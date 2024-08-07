package com.techlabs.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.Cell;
import com.techlabs.tictactoe.CellAlreadyMarkedException;
import com.techlabs.tictactoe.Game;
import com.techlabs.tictactoe.MarkType;
import com.techlabs.tictactoe.Player;
import com.techlabs.tictactoe.ResultAnalyzer;
import com.techlabs.tictactoe.ResultType;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {
    private Board board;
    private ResultAnalyzer analyzer;
    private Game game;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        Player[] players = {player1, player2};
        
        board = new Board();
        analyzer = new ResultAnalyzer(board);
        game = new Game(players, board, analyzer);
    }

    @Test
    public void testCreatedCellIsEmpty() {
        Cell cell = new Cell();
        assertTrue(cell.isEmpty());
    }

    @Test
    public void testSetMark_checkIfCanMarkX() throws CellAlreadyMarkedException {
        Cell cell = new Cell();
        cell.setMark(MarkType.X);
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    public void testSetMark_checkIfCanMarkO() throws CellAlreadyMarkedException {
        Cell cell = new Cell();
        cell.setMark(MarkType.O);
        assertEquals(MarkType.O, cell.getMark());
    }

    @Test
    public void testSetMark_throwsCellAlreadyMarkedExceptionWhenMarkedTwice() {
        final Cell cell = new Cell();
        assertThrows(CellAlreadyMarkedException.class, new Executable() {
			public void execute() throws Throwable {
			    cell.setMark(MarkType.X);
			    cell.setMark(MarkType.O);
			}
		});
    }

    @Test
    public void testHorizontalWinCheck() throws CellAlreadyMarkedException {
        board.setCellMark(0, MarkType.X);
        board.setCellMark(1, MarkType.X);
        board.setCellMark(2, MarkType.X);
        assertEquals(ResultType.WIN, analyzer.analyzeResult());
    }

    @Test
    public void testVerticalWinCheck() throws CellAlreadyMarkedException {
        board.setCellMark(0, MarkType.X);
        board.setCellMark(3, MarkType.X);
        board.setCellMark(6, MarkType.X);
        assertEquals(ResultType.WIN, analyzer.analyzeResult());
    }

    @Test
    public void testDiagonalWinCheck() throws CellAlreadyMarkedException {
        board.setCellMark(0, MarkType.X);
        board.setCellMark(4, MarkType.X);
        board.setCellMark(8, MarkType.X);
        assertEquals(ResultType.WIN, analyzer.analyzeResult());
    }

    @Test
    public void testDrawCondition() throws CellAlreadyMarkedException {
        // X O X
        // O X O
        // O X O
        board.setCellMark(0, MarkType.X);
        board.setCellMark(1, MarkType.O);
        board.setCellMark(2, MarkType.X);
        board.setCellMark(3, MarkType.O);
        board.setCellMark(4, MarkType.X);
        board.setCellMark(5, MarkType.O);
        board.setCellMark(6, MarkType.O);
        board.setCellMark(7, MarkType.X);
        board.setCellMark(8, MarkType.O);
        assertEquals(ResultType.DRAW, analyzer.analyzeResult());
    }

    @Test
    public void testSwitchCurrentPlayer() throws CellAlreadyMarkedException {
        assertEquals(player1, game.getCurrentPlayer());
        game.play(0); // Player 1 plays
        assertEquals(player2, game.getCurrentPlayer());
        game.play(1); // Player 2 plays
        assertEquals(player1, game.getCurrentPlayer());
    }
}

