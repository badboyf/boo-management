package com.book.book.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookDTO {
	private String id;
	private String identityNumber;
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

	private Integer version;
}
