package com.tdd.tictactoekata.service;

import com.tdd.tictactoekata.model.PlayerMove;

public class TicTacToeService {

	private char[][] board = new char[3][3];

	public String makeMove(PlayerMove playerMove) {

		int row = playerMove.getRow();
		int col = playerMove.getColumn();
		char currentPlayer = playerMove.getPlayer();

		board[row][col] = currentPlayer;

		return "Move completed!";
	}

	public String resetGame() {
		return "Game Rest!";
	}

}
