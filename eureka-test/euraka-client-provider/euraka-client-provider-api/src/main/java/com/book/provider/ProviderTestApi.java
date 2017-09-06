package com.book.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/p/test", headers = "Accept=application/json", produces = "application/json")
public interface ProviderTestApi {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test();

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String test(@PathVariable String id);
}
