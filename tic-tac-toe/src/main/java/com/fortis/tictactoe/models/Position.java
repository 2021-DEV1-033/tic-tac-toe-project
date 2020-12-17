package com.fortis.tictactoe.models;


/**
 * 
 * This is a simplified representation of a BoardPosition
 * A position into the board
 * 
 * @author the developer
 *
 */
public class Position extends BaseModel {
	private static final long serialVersionUID = 1L;

	private Integer vertical;
	private Integer horizontal;

	public Position() {
	}
	
	public Position(Integer vertical, Integer horizontal) {
		super();
		this.vertical = vertical;
		this.horizontal = horizontal;
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

}
