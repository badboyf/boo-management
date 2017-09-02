package com.book.user.domain.assemble;

import com.book.user.domain.model.User;
import com.book.user.dto.UserDTO;

public class UserAssemble {
	public static UserDTO assemble(User user) {
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setAvatar(user.getAvatar());
		userDTO.setUserName(user.getUserName());
		userDTO.setRealName(user.getRealName());
		userDTO.setVersion(user.getVersion());
		userDTO.setJob(user.getJob());
		userDTO.setDepartment(user.getDepartment());

		return userDTO;
	}
}
