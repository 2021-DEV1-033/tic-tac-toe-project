package com.fortis.tictactoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.models.GameModel;
import com.fortis.tictactoe.models.GameResult;
import com.fortis.tictactoe.models.PickBoxAction;
import com.fortis.tictactoe.services.GamePlayService;
import com.fortis.tictactoe.tools.TicTacToeTools;

@RestController
@RequestMapping(path = "/play")
public class GamePlayController {
	
	@Autowired
	private GamePlayService gamePlayService;
	
	@PostMapping(path = "/new-game", produces = "application/json", consumes = "application/json")
	public GameModel createNewGame(@RequestBody GameModel gameModel) {
		String playerOneName = gameModel.getFirstPlayer() == null 
				|| TicTacToeTools.isNullOrEmpty(gameModel.getFirstPlayer().getName()) ? 
						"Player 1" : gameModel.getFirstPlayer().getName();
		String playerTowName = gameModel.getSecondPlayer() == null 
				|| TicTacToeTools.isNullOrEmpty(gameModel.getSecondPlayer().getName()) ? 
						"Player 2" : gameModel.getSecondPlayer().getName();
		Game game = new Game(new Player(playerOneName), new Player(playerTowName));
		return GameModel.fromGame(gamePlayService.startGame(game));
	}
	
	@PutMapping(path = "/pick-a-box", produces = "application/json", consumes = "application/json")
	public GameResult pickBox(@RequestBody PickBoxAction action) {
		return gamePlayService.pickBox(action);
	}
	
}
