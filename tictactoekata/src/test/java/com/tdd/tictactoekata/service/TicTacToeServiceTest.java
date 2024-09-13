package com.tdd.tictactoekata.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeServiceTest {

	TicTacToeService ticTacToeService = new TicTacToeService();

	@Test
	public void testMakeMove_PlayerMakesMove_ReturnMoveCompleted() {

		PlayerMove player = new PlayerMove(0, 0, 'X');

		String result = ticTacToeService.makeMove(player);

		assertTrue(result.contains("Move completed"));
	}

	@Test
	public void testMakeMove_PlayerMakesInvalidMove_ReturnInvalidMove() {

		PlayerMove player = new PlayerMove(3, 0, 'X');

		String result = ticTacToeService.makeMove(player);

		assertTrue(result.contains("Invalid move"));
	}

	@Test
	public void testMakeMove_CheckBoardIsFull_ReturnGameIsDraw() {

		String result = fillBoard();

		assertTrue(result.contains("The game is a draw!"));
	}
	
	@Test
	public void testMakeMove_PlayerWinsByCompletingARow_ReturnPlayerWhoWins() {

		ticTacToeService.makeMove(new PlayerMove(0, 0, 'X')); 
	    ticTacToeService.makeMove(new PlayerMove(0, 1, 'X')); 
	    String result = ticTacToeService.makeMove(new PlayerMove(0, 2, 'X'));

		assertTrue(result.contains("Player X wins!"));
	}
	
	@Test
	public void testMakeMove_PlayerWinsByCompletingAColumn_ReturnPlayerWhoWins() {

		ticTacToeService.makeMove(new PlayerMove(0, 0, 'O')); 
	    ticTacToeService.makeMove(new PlayerMove(1, 0, 'O')); 
	    String result = ticTacToeService.makeMove(new PlayerMove(2, 0, 'O'));

		assertTrue(result.contains("Player O wins!"));
	}

	private String fillBoard() {

		String result = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result = ticTacToeService.makeMove(new PlayerMove(i, j, 'X'));
			}
		}
		return result;
	}
}
