package com.fortis.tictactoe.enums;

/**
 * 
 * The possible exception types
 * 
 * @author the developer
 *
 */
public enum ExceptionType {

	/**
	 * Server error exception type.
	 */
	SERVER_ERROR(500),
	
	/**
	 * Not found exception type.
	 */
	NOT_FOUND(404),
	
	/**
	 * Bad request exception type.
	 */
	BAD_REQUEST(400),
	
	/**
	 * Forbidden exception type.
	 */
	FORBIDDEN(403),
	
	/**
	 * Unauthorized exception type.
	 */
	UNAUTHORIZED(401);

	private int exceptionCode;

	ExceptionType(int exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * Value of exception type.
	 *
	 * @param exceptionCode the exception code
	 * @return the exception type
	 */
	public static ExceptionType valueOf(int exceptionCode) {
		for (ExceptionType exceptionType : ExceptionType.values()) {
			if (exceptionType.getExceptionCode() == exceptionCode) {
				return exceptionType;
			}
		}
		return null;
	}

	/**
	 * Gets exception code.
	 *
	 * @return the exception code
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}
}
