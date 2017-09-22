package com.book.lend.record.model.assemble;

import com.book.lend.record.dto.BookInfoDTO;
import com.book.lend.record.model.vo.BookInfo;

public class BookInfoAssemble {
	public static BookInfoDTO assemble(BookInfo bookInfo) {
		BookInfoDTO bookInfoDTO = new BookInfoDTO();
		bookInfoDTO.setAuthor(bookInfo.getAuthor());
		bookInfoDTO.setId(bookInfo.getId());
		bookInfoDTO.setName(bookInfo.getName());

		return bookInfoDTO;
	}
}
