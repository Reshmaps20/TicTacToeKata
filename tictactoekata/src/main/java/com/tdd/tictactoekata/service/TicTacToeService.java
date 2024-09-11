package com.tdd.tictactoekata.service;

import java.util.Arrays;

import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeService {

	private char[][] board = new char[3][3];

	public TicTacToeService() {
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public String makeMove(PlayerMove playerMove) {

		int row = playerMove.getRow();
		int col = playerMove.getColumn();
		char currentPlayer = playerMove.getPlayer();

		if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
			board[row][col] = currentPlayer;
			return "Move completed!";
		} else {
			return "Invalid move! Row and column must be between 0 and 2, and the cell must be empty.";
		}
	}

	public String resetGame() {
		return "Game Rest!";
	}

}
