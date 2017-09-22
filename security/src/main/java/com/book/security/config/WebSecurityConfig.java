package com.book.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomPostProcessor customPostProcessor(){
		return new CustomPostProcessor();
	}
	
	@Bean
	public AccessDecisionManager accessDecisionManager(){
		return new CustomAccessDecisionManager();
	}
	
	@Bean
	public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource(){
		return new CustomFilterSecurityMetadataSource();
	}
	
//	@Bean
//	public CustomAuthFilter customAuthFilter(){
//		return new CustomAuthFilter();
//	}
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsService);
//		.passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/*.html", "/v2/**","/swagger-resources","/validatorUrl","/configuration/**","/images/**", "/webjars/**").permitAll()
		.anyRequest().authenticated()
		.withObjectPostProcessor(customPostProcessor());
		
//		http.addFilterBefore(customAuthFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.headers().cacheControl();
	}
}
