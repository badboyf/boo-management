package com.book.user.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.book.domain.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	public Book findByName(String name);
}
