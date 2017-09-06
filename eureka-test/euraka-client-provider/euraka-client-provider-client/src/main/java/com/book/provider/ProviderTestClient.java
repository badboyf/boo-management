package com.book.provider;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test-service")
@RequestMapping(value = "/fallback")
public interface ProviderTestClient extends ProviderTestApi {

}
