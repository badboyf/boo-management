package com.book.user.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.user.dto.UserDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/user", headers = "Accept=application/json", produces = "application/json")
public interface UserApi {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ApiOperation(value = "注册", notes = "注册")
	public UserDTO register(@RequestBody UserDTO user);

	@RequestMapping(value = "/login", method =RequestMethod.POST)
	@ApiOperation(value = "登录", notes = "登录")
	public UserDTO login(@RequestBody UserDTO user);

	@RequestMapping(value = "/comparePassword", method = RequestMethod.PUT)
	@ApiOperation(value = "验证密码", notes = "验证密码")
	public UserDTO comparePassword(@RequestBody UserDTO user);

	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	@ApiOperation(value = "更新密码", notes = "更新密码")
	public void updatePassword(@RequestBody UserDTO user);

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	@ApiOperation(value = "通过用户名获取密码", notes = "通过用户名获取密码")
	public UserDTO getUser(@ApiParam(value = "用户名", name = "userName", required=true) @PathVariable String userName);
}
