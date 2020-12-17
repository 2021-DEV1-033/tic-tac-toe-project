package com.fortis.tictactoe.models;

/**
 * 
 * When a player chose a position to check, he must send a PickBoxAction containing his identifier and the game identifier
 * and the position to check 
 * 
 * @author the developer
 *
 */
public class PickBoxAction extends BaseModel {
	private static final long serialVersionUID = 1L;

	private String playerUuid;
	private String gameUuid;
	private Integer vertical;
	private Integer horizontal;

	public PickBoxAction() {
	}
	
	public PickBoxAction(String playerUuid, String gameUuid, Integer vertical, Integer horizontal) {
		super();
		this.playerUuid = playerUuid;
		this.gameUuid = gameUuid;
		this.vertical = vertical;
		this.horizontal = horizontal;
	}

	/**
	 * @return the playerUuid
	 */
	public String getPlayerUuid() {
		return playerUuid;
	}

	/**
	 * @param playerUuid the playerUuid to set
	 */
	public void setPlayerUuid(String playerUuid) {
		this.playerUuid = playerUuid;
	}

	/**
	 * @return the gameUuid
	 */
	public String getGameUuid() {
		return gameUuid;
	}

	/**
	 * @param gameUuid the gameUuid to set
	 */
	public void setGameUuid(String gameUuid) {
		this.gameUuid = gameUuid;
	}

	/**
	 * @return the vertical
	 */
	public Integer getVertical() {
		return vertical;
	}

	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(Integer vertical) {
		this.vertical = vertical;
	}

	/**
	 * @return the horizontal
	 */
	public Integer getHorizontal() {
		return horizontal;
	}

	/**
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(Integer horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
