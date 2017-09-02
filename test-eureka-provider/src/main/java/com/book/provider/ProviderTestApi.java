package com.book.provider;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/test", headers = "Accept=application/json", produces = "application/json")
@FeignClient(name = "test-service")
public interface ProviderTestApi {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test();
}
