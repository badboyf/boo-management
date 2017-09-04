package com.book.book.domain.factory;

import java.util.Date;

import com.book.book.domain.model.Book;
import com.book.book.dto.BookDTO;

public class BookFactory {
	public static Book factory(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setAuthor(bookDTO.getAuthor());
		book.setBookPDF(bookDTO.getBookPDF());
		book.setCatalog(bookDTO.getCatalog());
		book.setDepartment(bookDTO.getDepartment());
		book.setIdentityNumber(bookDTO.getIdentityNumber());
		book.setImages(bookDTO.getImages());
		book.setIntroduce(bookDTO.getIntroduce());
		book.setName(bookDTO.getName());
		book.setQuantity(bookDTO.getQuantity());
		book.setUpdateAt(bookDTO.getUpdateAt());
		book.setVersion(bookDTO.getVersion());
		book.setCreateAt(new Date());

		return book;
	}
}
