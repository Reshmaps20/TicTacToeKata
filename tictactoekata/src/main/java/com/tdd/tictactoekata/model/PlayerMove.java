package com.tdd.tictactoekata.model;

public class PlayerMove {

	private int row;
	private int column;
	private char player;

	public int getRow() {
		return row;
	}

	public PlayerMove(int row, int column, char player) {
		super();
		this.row = row;
		this.column = column;
		this.player = player;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}

}
