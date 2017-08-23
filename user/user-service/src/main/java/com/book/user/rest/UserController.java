package com.book.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.user.api.UserApi;
import com.book.user.domain.assemble.UserAssemble;
import com.book.user.domain.factory.UserFactory;
import com.book.user.domain.module.User;
import com.book.user.domain.repository.UserRepository;
import com.book.user.dto.UserDTO;
import com.book.user.exception.ExceptionConstant;
import com.book.user.exception.RunException;

@RestController
public class UserController implements UserApi {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO register(@RequestBody UserDTO userDTO) {
		User user = UserFactory.factory(userDTO);
		user = userRepository.save(user);
		return UserAssemble.assemble(user);
	}

	@Override
	public UserDTO login(@RequestBody UserDTO userDTO) {
		User user = userRepository.getByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());

		return UserAssemble.assemble(user);
	}

	@Override
	public UserDTO comparePassword(@RequestBody UserDTO userDTO) {
		User user = userRepository.findOne(userDTO.getId());
		if (user == null) {
			throw new RunException(ExceptionConstant.USER_NOT_FOUND);
		} else if (!userDTO.getPassword().equals(user.getPassword())) {
			throw new RunException(ExceptionConstant.PASSWORD_WRONG);
		}

		return UserAssemble.assemble(user);
	}

	@Override
	public void updatePassword(@RequestBody UserDTO userDTO) {
		User user = userRepository.findOne(userDTO.getId());
		user.setPassword(userDTO.getPassword());
		userRepository.save(user);
	}

}
