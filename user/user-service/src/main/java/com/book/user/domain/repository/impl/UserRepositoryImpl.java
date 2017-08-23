package com.book.user.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.book.user.domain.module.User;
import com.book.user.domain.repository.UserCustormRepository;
import com.book.user.exception.ExceptionConstant;
import com.book.user.exception.RunException;

public class UserRepositoryImpl implements UserCustormRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public User getByUserNameAndPassword(String userName, String password) {
		Query query = new Query();
		Criteria criteria = Criteria.where("username").is(userName).and("password").is(password);
		query.addCriteria(criteria);

		List<User> users = mongoTemplate.find(query, User.class);
		if (users.size() > 1) {
			throw new RunException(ExceptionConstant.USERNAME_PASSWORD_MORE_THAN_ONE);
		} else if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
