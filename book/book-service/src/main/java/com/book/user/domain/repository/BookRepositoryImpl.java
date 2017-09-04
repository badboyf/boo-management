package com.book.user.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import com.book.book.domain.model.Book;

public class BookRepositoryImpl implements BookCustormRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Book> find(String name) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		if (!StringUtils.isEmpty(name)) {
			query.addCriteria(Criteria.where("name").regex(name));
		}
		query.addCriteria(criteria);
		return mongoTemplate.find(query, Book.class);
	}

}
