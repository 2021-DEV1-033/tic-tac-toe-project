package com.fortis.tictactoe.services;

import com.fortis.tictactoe.entities.Game;
import com.fortis.tictactoe.models.GameResult;
import com.fortis.tictactoe.models.PickBoxAction;

/**
 * Game Play Service<br>
 * 
 * This is the main service, the way to start game, and check a box 
 * and retrieve game result
 * 
 * @author the developer
 *
 */
public interface GamePlayService {
	/**
	 * Start new game, create new game on the database, and start playing 
	 * @param game
	 * @return the saved {@link Game}
	 */
	Game startGame(Game game);
	
	/**
	 * 
	 * This method will perform position check, and result calculation and will return the result {@link GameResult} of the game, final or current
	 * 
	 * @param action : the {@link PickBoxAction} instance containing the action data
	 * @return the {@link GameResult}
	 */
	GameResult pickBox(PickBoxAction action);
}
