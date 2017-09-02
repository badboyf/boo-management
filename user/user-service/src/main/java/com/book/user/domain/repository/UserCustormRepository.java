package com.book.user.domain.repository;

import com.book.user.domain.model.User;

public interface UserCustormRepository {
	public User getByUserNameAndPassword(String userName, String password);

	public User getByUserName(String userName);
}
