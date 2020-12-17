package com.fortis.tictactoe.models;

import java.io.Serializable;

/**
 * The Api response.
 *
 * @param <T> the data class type
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T data;
    private Boolean success = Boolean.TRUE;
    private String error;
    

    /**
     * Instantiates a new Api response.
     */
    public ApiResponse() {
    }

    /**
     * Instantiates a new Api response.
     *
     * @param data the data
     */
    public ApiResponse(T data) {
        this.data = data;
    }

    /**
     * Instantiates a new Api response.
     *
     * @param data    the data
     * @param success the success status
     * @param error   the error message
     */
    public ApiResponse(T data, Boolean success, String error) {
        this.data = data;
        this.success = success;
        this.error = error;
    }

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the success status
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success : the success status to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the error message
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error : the error message to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the serial version uid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
