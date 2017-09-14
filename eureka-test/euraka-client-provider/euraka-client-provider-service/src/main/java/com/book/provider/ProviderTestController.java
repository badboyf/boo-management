package com.book.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("providerTestController")
public class ProviderTestController implements ProviderTestApi {

	@Override
	public String test() {
		return "hello world";
	}

	@Override
	public String test(@PathVariable String id) {
		System.out.println(id);
		return "hello" + id;
	}

}
