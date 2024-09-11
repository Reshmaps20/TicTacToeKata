package com.tdd.tictactoekata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdd.tictactoekata.model.PlayerMove;
import com.tdd.tictactoekata.service.TicTacToeService;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {

	@Autowired
	TicTacToeService ticTacToeService;

	@PostMapping("/playgame")
	public String makeMove(@RequestBody PlayerMove playerMove) {
		return ticTacToeService.makeMove(playerMove);
	}	
	

}
