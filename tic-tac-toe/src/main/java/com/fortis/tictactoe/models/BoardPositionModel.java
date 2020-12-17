package com.fortis.tictactoe.models;

import com.fortis.tictactoe.entities.BoardPosition;

public class BoardPositionModel {

	private Integer vertical;
	private Integer horizontal;
	private boolean checked = false;
	private PlayerModel player;

	public BoardPositionModel() {
	}
	
	public BoardPositionModel(Integer vertical, Integer horizontal, boolean checked, PlayerModel player) {
		super();
		this.vertical = vertical;
		this.horizontal = horizontal;
		this.checked = checked;
		this.player = player;
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
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @return the player
	 */
	public PlayerModel getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(PlayerModel player) {
		this.player = player;
	}
	
	public static BoardPositionModel from(BoardPosition boardPosition) {
		return new BoardPositionModel(boardPosition.getVertical(), boardPosition.getHorizontal(),
				boardPosition.isChecked(), boardPosition.getPlayer() != null ? PlayerModel.fromPlayer(boardPosition.getPlayer()) : null);
	}
	
}
