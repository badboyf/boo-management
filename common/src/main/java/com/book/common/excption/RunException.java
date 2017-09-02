package com.book.common.excption;

import com.book.common.constant.ExceptionConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RunException extends RuntimeException {

	private static final long serialVersionUID = 5100070955647030660L;

	private String code;
	private String reason;

	public RunException(ExceptionConstant constant) {
		this.code = constant.getCode();
		this.reason = constant.getMessage();
	}

	public RunException(ExceptionConstant constant, String reason) {
		this.code = constant.getCode();
		this.reason = constant.getMessage() + "【reason: " + reason + "】";
	}
}
