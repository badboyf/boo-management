package com.book.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.provider.ProviderTestClient;

@RestController("consumerTestController")
@RequestMapping(value = "/c/test")
public class ConsumerTestController {
	@Autowired
	ProviderTestClient client;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test() {
		System.out.println(client.test());
		return client.test();
	}

}
