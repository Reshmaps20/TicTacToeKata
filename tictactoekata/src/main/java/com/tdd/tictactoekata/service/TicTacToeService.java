package com.tdd.tictactoekata.service;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeService {

	private char[][] board = new char[3][3];
	private boolean gameDraw = false;
	private boolean gameWon = false;

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

		if (isBoardFull()) {
			gameDraw = true;
			return "The game is a draw!";
		}
		if (checkRows(currentPlayer) || checkColumns(currentPlayer)) {
			gameWon = true;
			return "Player " + currentPlayer + " wins!";
		}

		return "Move completed!";
	}

	private boolean checkColumns(char currentPlayer) {
		return IntStream.range(0, 3).anyMatch(i -> (IntStream.range(0, 3).allMatch(j -> board[j][i] == currentPlayer)));
	}

	private boolean checkRows(char currentPlayer) {
		return IntStream.range(0, 3).anyMatch(i -> (IntStream.range(0, 3).allMatch(j -> board[i][j] == currentPlayer)));
	}

	private boolean isBoardFull() {
		return Arrays.stream(board).flatMapToInt(row -> IntStream.range(0, row.length).map(i -> row[i]))
				.noneMatch(cell -> cell == ' ');
	}

	private boolean isValidMove(int row, int col) {
		return IntStream.of(row, col).allMatch(i -> i >= 0 && i < 3) && board[row][col] == ' ';
	}

	public String resetGame() {
		return "Game Rest!";
	}

}
