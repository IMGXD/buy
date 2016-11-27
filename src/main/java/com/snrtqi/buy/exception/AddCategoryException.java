package com.snrtqi.buy.exception;

/**
 * 添加分类信息异常
 * 
 * @author Gumo
 *
 */
public class AddCategoryException extends Exception {

	// 异常信息
	public String message;

	public AddCategoryException(String message) {
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
