package com.tdd.tictactoekata.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeServiceTest {

	public static final String GAME_OVER = "Game is already over";
	public static final String INVALID_MOVE = "Invalid move";
	public static final String GAME_RESET = "Game Reset";
	public static final String WINNER_X = "Player X wins!";
	public static final String WINNER_O = "Player O wins!";
	public static final String DRAW = "The game is a draw!";
	public static final String MOVE_COMPELETED = "Move completed";

	TicTacToeService ticTacToeService = new TicTacToeService();

	@Test
	public void testMakeMove_PlayerMakesMove_ReturnMoveCompleted() {

		PlayerMove player = new PlayerMove(0, 0, 'X');
		String result = ticTacToeService.makeMove(player);
		assertTrue(result.contains(MOVE_COMPELETED));
	}

	@Test
	public void testMakeMove_PlayerMakesInvalidMove_ReturnInvalidMove() {

		PlayerMove player = new PlayerMove(3, 0, 'X');
		String result = ticTacToeService.makeMove(player);
		assertTrue(result.contains(INVALID_MOVE));
	}

	@Test
	public void testMakeMove_CheckBoardIsFull_ReturnGameIsDraw() {

		String result = fillBoard();
		assertTrue(result.contains(DRAW));
	}

	@Test
	public void testMakeMove_PlayerWinsByCompletingARow_ReturnPlayerWhoWins() {

		playMoves(new PlayerMove(0, 0, 'X'), new PlayerMove(0, 1, 'X'));
		String result = ticTacToeService.makeMove(new PlayerMove(0, 2, 'X'));
		assertTrue(result.contains(WINNER_X));
	}

	@Test
	public void testMakeMove_PlayerWinsByCompletingAColumn_ReturnPlayerWhoWins() {

		playMoves(new PlayerMove(0, 0, 'O'), new PlayerMove(1, 0, 'O'));
		String result = ticTacToeService.makeMove(new PlayerMove(2, 0, 'O'));
		assertTrue(result.contains(WINNER_O));
	}

	@Test
	public void testMakeMove_PlayerWinsByCompletingADiagonal_ReturnPlayerWhoWins() {

		playMoves(new PlayerMove(0, 0, 'O'), new PlayerMove(1, 1, 'O'));
		String result = ticTacToeService.makeMove(new PlayerMove(2, 2, 'O'));
		assertTrue(result.contains(WINNER_O));
	}

	@Test
	public void testMakeMove_CheckTheGameIsWonOrDraw_ReturnGameOver() {

		playMoves(new PlayerMove(0, 0, 'O'), new PlayerMove(1, 1, 'O'), new PlayerMove(2, 2, 'O'));
		String result = ticTacToeService.makeMove(new PlayerMove(1, 0, 'X'));
		assertTrue(result.contains(GAME_OVER));
	}

	@Test
	public void testReset_ResetTheGame_ReturnGameReset() {

		String result = ticTacToeService.resetGame();
		assertTrue(result.contains(GAME_RESET));
	}

	private String fillBoard() {

		String result = "";
		char[][] moves = { { 'X', 'O', 'X' }, { 'O', 'O', 'X' }, { 'X', 'X', 'O' } };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result = ticTacToeService.makeMove(new PlayerMove(i, j, moves[i][j]));
			}
		}
		return result;
	}

	private void playMoves(PlayerMove... moves) {
		for (PlayerMove move : moves) {
			ticTacToeService.makeMove(move);
		}
	}
}
