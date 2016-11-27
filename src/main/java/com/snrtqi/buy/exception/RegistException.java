package com.snrtqi.buy.exception;

/**
 * 注册用户异常
 * 
 * @author Gumo
 *
 */
public class RegistException extends Exception {

	// 异常信息
	public String message;

	public RegistException(String message) {
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
