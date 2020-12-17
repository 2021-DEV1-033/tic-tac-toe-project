package com.fortis.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fortis.tictactoe.entities.BoardPosition;
import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.entities.Player;
import com.fortis.tictactoe.entities.TicTacToeBoard;
import com.fortis.tictactoe.enums.GameStatus;
import com.fortis.tictactoe.models.GameResult;
import com.fortis.tictactoe.models.PickBoxAction;
import com.fortis.tictactoe.services.GamePlayService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TicTacToeGameTest {
	
	@Autowired
	private GamePlayService gamePlayService;
	
	@Test
	void contextLoads() {
	}
	
	/**
	 * This test perform a full game play test, from creation till the end of the game
	 */
	@Test
	void winAGameTest() {		
		Game game = new Game(new Player("player 1"), new Player("player 2"));
		gamePlayService.startGame(game);
		
		String firstPlayerUuid = game.getPlayerOne().getUuid();
		String secondPlayerUuid = game.getPlayerTow().getUuid();
		gamePlayService.pickBox(new PickBoxAction(firstPlayerUuid, game.getUuid(), 0, 0));
		gamePlayService.pickBox(new PickBoxAction(secondPlayerUuid, game.getUuid(), 0, 1));
		gamePlayService.pickBox(new PickBoxAction(firstPlayerUuid, game.getUuid(), 1, 0));
		gamePlayService.pickBox(new PickBoxAction(secondPlayerUuid, game.getUuid(), 0, 2));
		GameResult gameResult = gamePlayService.pickBox(new PickBoxAction(firstPlayerUuid, game.getUuid(), 2, 0));
		
		assertEquals(gameResult.getGameStatus(), GameStatus.FINISHED);
		assertEquals(gameResult.getWinner(), game.getPlayerOne().getName());
		
	}
	
}
