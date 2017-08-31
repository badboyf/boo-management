package com.book.provider;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderTestController implements ProviderTestApi {

	@Override
	public String test() {
		return "hello world";
	}

}
