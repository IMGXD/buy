package com.snrtqi.buy.exception;

/**
 * 删除分类信息异常
 * 
 * @author Gumo
 *
 */
public class DeleteCategoryException extends Exception {

	// 异常信息
	public String message;

	public DeleteCategoryException(String message) {
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
