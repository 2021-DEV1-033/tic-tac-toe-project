package com.fortis.tictactoe.models;

import com.fortis.tictactoe.enums.ExceptionType;

/**
 * The type Api exception.
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ExceptionType exceptionType;

    /**
     * Instantiates a new Api exception.
     */
    public ApiException() {
        super(ExceptionType.BAD_REQUEST.name());
        this.exceptionType = ExceptionType.BAD_REQUEST;
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param exceptionType the exception type
     */
    public ApiException(ExceptionType exceptionType) {
        super(exceptionType.name());
        this.exceptionType = exceptionType;
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param message       the message
     * @param exceptionType the exception type
     */
    public ApiException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param message       the message
     * @param cause         the cause
     * @param exceptionType the exception type
     */
    public ApiException(String message, Throwable cause, ExceptionType exceptionType) {
        super(message, cause);
        this.exceptionType = exceptionType;
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param cause         the cause
     * @param exceptionType the exception type
     */
    public ApiException(Throwable cause, ExceptionType exceptionType) {
        super(cause);
        this.exceptionType = exceptionType;
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     * @param exceptionType      the exception type
     */
    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionType exceptionType) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionType = exceptionType;
    }

    /**
     * Gets exception type.
     *
     * @return the exception type
     */
    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    /**
     * Sets exception type.
     *
     * @param exceptionType the exception type
     */
    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
