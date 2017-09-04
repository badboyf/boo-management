package com.book.book.domain.model;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "book")
@Data
public class Book implements Comparator<Book> {
	@Id
	private String id;

	@Indexed
	private String identityNumber;
	@Indexed
	private String name;
	private Integer quantity;
	private String author;
	private String department;
	private String introduce;
	private String catalog;
	private List<String> images;
	private List<String> bookPDF;

	private Date createAt;
	private Date updateAt;

	@Version
	private Integer version;

	public void updateInfo(Book book) {
		this.name = book.getName();
		this.quantity = book.getQuantity();
		this.author = book.getAuthor();
		this.introduce = book.getIntroduce();
		this.catalog = book.getCatalog();
		this.images = book.getImages();
		this.bookPDF = book.getBookPDF();
		this.updateAt = new Date();
	}

	@Override
	public int compare(Book o1, Book o2) {

		return (int) (o2.getCreateAt().getTime() - o1.getCreateAt().getTime());
	}
}
