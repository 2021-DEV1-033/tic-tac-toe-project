package com.fortis.tictactoe.models;

import com.fortis.tictactoe.enums.GameStatus;
import com.fortis.tictactoe.enums.LineType;


/**
 * 
 * After every check, the application verify if there is a winner, 
 * and return a GameResult instance with the game status and the winner if possible
 * 
 * @author the developer
 *
 */
public class GameResult extends BaseModel {
	private static final long serialVersionUID = 1L;

	private String winner;
	private LineType wonLineType;
	private Position lastPlayedPosition;
	private GameStatus gameStatus;

	public GameResult() {
	}
	
	public GameResult(String winner, LineType wonLineType, Position lastPlayedPosition, GameStatus gameStatus) {
		super();
		this.winner = winner;
		this.wonLineType = wonLineType;
		this.lastPlayedPosition = lastPlayedPosition;
		this.gameStatus = gameStatus;
	}

	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * @return the wonLineType
	 */
	public LineType getWonLineType() {
		return wonLineType;
	}

	/**
	 * @param wonLineType the wonLineType to set
	 */
	public void setWonLineType(LineType wonLineType) {
		this.wonLineType = wonLineType;
	}

	/**
	 * @return the last Played Position
	 */
	public Position getLastPlayedPosition() {
		return lastPlayedPosition;
	}

	/**
	 * @param lastPlayedPosition the last Played Position to set
	 */
	public void setLastPlayedPosition(Position lastPlayedPosition) {
		this.lastPlayedPosition = lastPlayedPosition;
	}

	/**
	 * @return the gameStatus
	 */
	public GameStatus getGameStatus() {
		return gameStatus;
	}

	/**
	 * @param gameStatus the gameStatus to set
	 */
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

}
