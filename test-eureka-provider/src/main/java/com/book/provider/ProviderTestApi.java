package com.book.provider;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "test-service", value = "providerTestApi")
public interface ProviderTestApi {

	public String test();
}
