package com.book.book.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.api.BookApi;
import com.book.book.domain.assemble.BookAssemble;
import com.book.book.domain.factory.BookFactory;
import com.book.book.domain.model.Book;
import com.book.book.dto.BookDTO;
import com.book.common.constant.ExceptionConstant;
import com.book.common.excption.RunException;
import com.book.user.domain.repository.BookRepository;

@RestController
public class BookController implements BookApi {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO) {
		Book result = null;
		if (bookDTO.getId() == null) {
			result = createBook(bookDTO);
		} else {
			result = updateBook(bookDTO);
		}

		return BookAssemble.assemble(result);
	}

	private Book createBook(BookDTO bookDTO) {
		if (bookRepository.findByName(bookDTO.getName()) != null) {
			throw new RunException(ExceptionConstant.BOOK_ALREADY_EXIST, "book name exist");
		}
		Book book = BookFactory.factory(bookDTO);

		return bookRepository.save(book);
	}

	private Book updateBook(BookDTO bookDTO) {
		Book book = bookRepository.findOne(bookDTO.getId());
		if (book == null) {
			throw new RunException(ExceptionConstant.BOOK_NOT_EXIST);
		}
		book.updateInfo(BookFactory.factory(bookDTO));

		return bookRepository.save(book);
	}

	@Override
	public BookDTO getById(@PathVariable String id) {
		Book book = bookRepository.findOne(id);
		if (book == null) {
			throw new RunException(ExceptionConstant.BOOK_NOT_EXIST);
		}
		return BookAssemble.assemble(book);
	}

	@Override
	public List<BookDTO> getBooks(@RequestParam(name = "name", required = false) String name) {
		List<Book> books = bookRepository.find(name);
		books.sort(new Book());
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		for (Book book : books) {
			bookDTOs.add(BookAssemble.assemble(book));
		}

		return bookDTOs;
	}

	@Override
	public void deleteById(@PathVariable(value = "id") String id) {
		Book book = bookRepository.findOne(id);
		if (book == null) {
			throw new RunException(ExceptionConstant.BOOK_NOT_EXIST);
		}
		bookRepository.delete(book);
	}

}
