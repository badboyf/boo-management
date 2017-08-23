package com.book.user.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.user.dto.UserDTO;

@RequestMapping(value = "/user", headers = "Accept=application/json", produces = "application/json")
public interface UserApi {

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public UserDTO register(@RequestBody UserDTO user);

	@RequestMapping(value = "login", method =RequestMethod.POST)
	public UserDTO login(@RequestBody UserDTO user);

	@RequestMapping(value = "comparePassword", method = RequestMethod.PUT)
	public UserDTO comparePassword(@RequestBody UserDTO user);

	@RequestMapping(value = "updatePassword", method = RequestMethod.PUT)
	public void updatePassword(@RequestBody UserDTO user);
}
