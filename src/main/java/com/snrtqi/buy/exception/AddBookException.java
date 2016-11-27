package com.snrtqi.buy.exception;

/**
 * 添加分类信息异常
 * 
 * @author Gumo
 *
 */
public class AddBookException extends Exception {

	// 异常信息
	public String message;

	public AddBookException(String message) {
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
