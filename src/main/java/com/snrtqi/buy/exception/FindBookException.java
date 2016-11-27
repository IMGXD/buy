package com.snrtqi.buy.exception;

/**
 * 查找图书异常
 * 
 * @author Gumo
 *
 */
public class FindBookException extends Exception {

	// 异常信息
	public String message;

	public FindBookException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
