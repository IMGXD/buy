package com.snrtqi.buy.exception;

/**
 * 更新分类信息异常
 * 
 * @author Gumo
 *
 */
public class UpdateCategoryException extends Exception {

	// 异常信息
	public String message;

	public UpdateCategoryException(String message) {
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
