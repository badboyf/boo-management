package com.book.common.constant;

public enum ExceptionConstant {
	UPLOAD_FILE_ERROR("007", "上传文件失败"),
	BOOK_NOT_EXIST("006", "书不存在"),
	BOOK_ALREADY_EXIST("005", "书已经存在"),
	USER_ALREADY_EXIST("004", "用户已经存在"),
	PASSWORD_WRONG("003", "密码错误"),
	USER_NOT_FOUND("002", "用户不存在"),
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
