package com.book.common.constant;

public enum ExceptionConstant {
	USER_ALREADY_EXIST("004", "用户已经存在"),
	PASSWORD_WRONG("003", "密码错误"),
	USER_NOT_FOUND("002", "未根据id获取用户信息"),
	USERNAME_PASSWORD_MORE_THAN_ONE("001", "根据用户名和密码查找数据多余一条");

	private String code;
	private String message;

	private ExceptionConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}