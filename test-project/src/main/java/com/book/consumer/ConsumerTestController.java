package com.book.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.provider.ProviderTestApi;

@RestController
@RequestMapping(value = "/test")
public class ConsumerTestController {
	@Autowired
	ProviderTestApi providerTestApi;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test() {
		System.out.println(providerTestApi.test());
		return providerTestApi.test();
	}
}
