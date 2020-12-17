package com.fortis.tictactoe.enums;


/**
 * 
 * This enum represent the line direction, the sequence of checked boxes must be HORIZONTAL, VERTICAL or a DIAMETER
 * 
 * @author the developer
 *
 */
public enum LineType {

	HORIZONTAL(0),
	VERTICAL(1),
	LEFT_DIAMETER(100),
	RIGHT_DIAMETER(101);

	private int lineCode;

	LineType(int lineCode) {
		this.lineCode = lineCode;
	}

	/**
	 * Value of exception type.
	 *
	 * @param exceptionCode the exception code
	 * @return the exception type
	 */
	public static LineType valueOf(int lineCode) {
		for (LineType lineType : LineType.values()) {
			if (lineType.getLineCode() == lineCode) {
				return lineType;
			}
		}
		return null;
	}

	/**
	 * Gets exception code.
	 *
	 * @return the exception code
	 */
	public int getLineCode() {
		return lineCode;
	}
}
