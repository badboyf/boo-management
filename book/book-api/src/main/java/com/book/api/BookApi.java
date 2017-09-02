package com.book.api;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.book.dto.BookDTO;

@RequestMapping(value = "/book")
public interface BookApi {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO);

	@RequestMapping(value = "/{identityNumber}", method = RequestMethod.GET)
	public BookDTO getById(@PathVariable(value = "identityNumber") String identityNumber);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<BookDTO> getBooks();

}
