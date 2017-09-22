package com.book.url.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
	List<Url> findByUrl(String url);

	Url findByUrlAndMethod(String url, String method);
}
