package com.book.url.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "url")
@Data
public class Url {
	@Id
	private String id;

	private String url;

	private List<String> roles;

	private String method;
}
