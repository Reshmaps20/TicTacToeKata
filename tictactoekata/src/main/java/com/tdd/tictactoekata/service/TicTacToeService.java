package com.tdd.tictactoekata.service;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeService {

	private char[][] board = new char[3][3];
	private boolean gameDraw = false;

	public TicTacToeService() {
		initializeBoard();
	}

	private void initializeBoard() {
		Arrays.stream(board).forEach(row -> Arrays.fill(row, ' '));
	}

	public String makeMove(PlayerMove playerMove) {

		int row = playerMove.getRow();
		int col = playerMove.getColumn();
		char currentPlayer = playerMove.getPlayer();

		if (!isValidMove(row, col)) {
			return "Invalid move! Row and column must be between 0 and 2, and the cell must be empty.";
		}
		board[row][col] = currentPlayer;
		return "Move completed!";
	}

	private boolean isValidMove(int row, int col) {
		return IntStream.of(row, col).allMatch(i -> i >= 0 && i < 3) && board[row][col] == ' ';
	}

	public String resetGame() {
		return "Game Rest!";
	}

}
