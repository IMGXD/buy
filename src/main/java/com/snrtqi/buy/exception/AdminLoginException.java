package com.snrtqi.buy.exception;

/**
 * 登录异常
 * 
 * @author Gumo
 *
 */
public class AdminLoginException extends Exception {

	// 异常信息
	public String message;

	public AdminLoginException(String message) {
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
