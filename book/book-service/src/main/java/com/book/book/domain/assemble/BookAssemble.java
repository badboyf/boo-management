package com.book.book.domain.assemble;

import com.book.book.domain.model.Book;
import com.book.book.dto.BookDTO;

public class BookAssemble {
	public static BookDTO assemble(Book book) {
		if (book == null) {
			return null;
		}
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setBookPDF(book.getBookPDF());
		bookDTO.setCatalog(book.getCatalog());
		bookDTO.setCreateAt(book.getCreateAt());
		bookDTO.setDepartment(book.getDepartment());
		bookDTO.setIdentityNumber(book.getIdentityNumber());
		bookDTO.setImages(book.getImages());
		bookDTO.setIntroduce(book.getIntroduce());
		bookDTO.setName(book.getName());
		bookDTO.setQuantity(book.getQuantity());
		bookDTO.setUpdateAt(book.getUpdateAt());
		bookDTO.setVersion(book.getVersion());

		return bookDTO;
	}
}
