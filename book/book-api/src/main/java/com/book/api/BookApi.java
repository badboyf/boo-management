package com.book.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.book.dto.BookDTO;

@RequestMapping(value = "/book")
public interface BookApi {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BookDTO getById(@PathVariable(value = "id") String id);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<BookDTO> getBooks(@RequestParam(name = "name", required = false) String name);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") String id);
}
