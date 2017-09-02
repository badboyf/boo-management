package com.book.user.domain.factory;

import com.book.user.domain.model.User;
import com.book.user.dto.UserDTO;

public class UserFactory {
	public static User factory(UserDTO userDTO) {
		return new User(userDTO);
	}
}
