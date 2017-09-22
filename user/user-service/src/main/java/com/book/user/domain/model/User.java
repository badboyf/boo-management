package com.book.user.domain.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import com.book.user.dto.UserDTO;

import lombok.Data;

@Document(collection = "user")
@Data
public class User {
	@Id
	private String id;
	private String userName;

	private String password;
	private String realName;
	private String department;
	private String avatar;
	private String job;
	
	private List<String> roles;

	@Version
	private Integer version;

	public User() {
	}

	public User(UserDTO userDTO) {
		this.userName = userDTO.getUserName();
		this.realName = userDTO.getRealName();
		this.password = userDTO.getPassword();
		this.department = userDTO.getDepartment();
		this.avatar = userDTO.getAvatar();
		this.job = userDTO.getJob();
	}
}
