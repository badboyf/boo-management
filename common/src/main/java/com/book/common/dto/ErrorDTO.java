package com.book.common.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.book.common.excption.RunException;

import lombok.Data;

@Data
public class ErrorDTO {
	private String code;
	private String message;
	private Timestamp timestamp;

	public ErrorDTO(RunException ex) {
		this.code = ex.getCode();
		this.message = ex.getReason();
		this.timestamp = new Timestamp(new Date().getTime());
	}
}
