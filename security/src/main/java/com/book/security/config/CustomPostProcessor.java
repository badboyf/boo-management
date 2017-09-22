package com.book.security.config;

import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

public class CustomPostProcessor implements ObjectPostProcessor<FilterSecurityInterceptor> {

	@Override
	public <O extends FilterSecurityInterceptor> O postProcess(O filterInterceptor) {
		filterInterceptor.setAccessDecisionManager(new CustomAccessDecisionManager());
		filterInterceptor.setSecurityMetadataSource(new CustomFilterSecurityMetadataSource());

		return filterInterceptor;
	}

}
