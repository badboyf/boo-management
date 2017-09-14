package com.book.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.common.constant.ExceptionConstant;
import com.book.common.excption.RunException;
import com.book.user.api.UserApi;
import com.book.user.domain.assemble.UserAssemble;
import com.book.user.domain.factory.UserFactory;
import com.book.user.domain.model.User;
import com.book.user.domain.repository.UserRepository;
import com.book.user.dto.UserDTO;

@RestController
public class UserController implements UserApi {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO register(@RequestBody UserDTO userDTO) {
		User existUser = userRepository.getByUserName(userDTO.getUserName());
		if (existUser != null) {
			throw new RunException(ExceptionConstant.USER_ALREADY_EXIST);
		}
		User user = UserFactory.factory(userDTO);
		user = userRepository.save(user);
		return UserAssemble.assemble(user);
	}

	@Override
	public UserDTO login(@RequestBody UserDTO userDTO) {
		User user = userRepository.getByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
		System.out.println("@@@@@@@@@@@@");
		if (user == null) {
			throw new RunException(ExceptionConstant.PASSWORD_WRONG);
		}
		
		return UserAssemble.assemble(user);
	}

	@Override
	public UserDTO comparePassword(@RequestBody UserDTO userDTO) {
		User user = userRepository.getByUserName(userDTO.getUserName());
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

	@Override
	public UserDTO getUser(@PathVariable String userName) {
		User existUser = userRepository.getByUserName(userName);
		if (existUser == null) {
			throw new RunException(ExceptionConstant.USER_NOT_FOUND);
		}
		return UserAssemble.assemble(existUser);
	}
}
