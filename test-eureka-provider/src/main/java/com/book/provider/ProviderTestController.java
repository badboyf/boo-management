package com.book.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("providerTestController")
@RequestMapping(value = "/test", headers = "Accept=application/json", produces = "application/json")
public class ProviderTestController implements ProviderTestApi {

	@RequestMapping(value = "", method = RequestMethod.GET)
	@Override
	public String test() {
		return "hello world";
	}

}
