package com.book.user.domain.repository;

import java.util.List;

import com.book.book.domain.model.Book;

public interface BookCustormRepository {
	public List<Book> find(String name);
}
