package com.book.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDTO {
	private String id;
	private String userName;

	@JsonIgnore
	private String password;
	private String realName;
	private String department;
	private String job;
	private String avatar;
	private Integer version;
}
