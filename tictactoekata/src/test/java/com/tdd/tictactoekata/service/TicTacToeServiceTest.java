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

}
