package com.book.lend.record.model.factory;

import com.book.lend.record.dto.BookInfoDTO;
import com.book.lend.record.model.vo.BookInfo;

public class BookInfoFactory {
	public static BookInfo factory(BookInfoDTO bookInfoDTO) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setAuthor(bookInfoDTO.getAuthor());
		bookInfo.setId(bookInfoDTO.getId());
		bookInfo.setName(bookInfoDTO.getName());

		return bookInfo;
	}
}
