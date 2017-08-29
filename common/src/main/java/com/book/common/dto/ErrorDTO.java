package com.book.common.dto;

import com.book.common.excption.RunException;

import lombok.Data;

@Data
public class ErrorDTO {
	private String code;
	private String message;

	public ErrorDTO(RunException ex) {
		this.code = ex.getCode();
		this.message = ex.getMessage();
	}
}
