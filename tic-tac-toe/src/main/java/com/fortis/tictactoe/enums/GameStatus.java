package com.fortis.tictactoe.enums;


/**
 * 
 * the game status representation
 * 
 * @author the developer
 *
 */
public enum GameStatus {

	IN_PROGRESS(0),
	FINISHED(1);

	private int gameStatusCode;

	GameStatus(int gameStatusCode) {
		this.gameStatusCode = gameStatusCode;
	}

	/**
	 * Value of exception type.
	 *
	 * @param exceptionCode the exception code
	 * @return the exception type
	 */
	public static GameStatus valueOf(int gameStatusCode) {
		for (GameStatus gameStatus : GameStatus.values()) {
			if (gameStatus.getGameStatusCode() == gameStatusCode) {
				return gameStatus;
			}
		}
		return null;
	}

	/**
	 * Gets exception code.
	 *
	 * @return the exception code
	 */
	public int getGameStatusCode() {
		return gameStatusCode;
	}
}
