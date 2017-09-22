package com.book.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.book.url.model.Url;
import com.book.url.model.UrlRepository;

public class CustomAuthFilter extends OncePerRequestFilter {
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UrlRepository urlRepository;

	@Value("${auth.header}")
	private String authHeader;

	@Value("${auth.prefix}")
	private String authPrefix;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String urlStr = request.getRequestURI();
		if (urlStr.endsWith(".html")) {

		}

		String authHeader = request.getHeader(this.authHeader);
		String username = authHeader;
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (userDetails != null) {
			String method = request.getMethod();
			Url url = urlRepository.findByUrlAndMethod(urlStr, method);

			boolean flag = false;
			if (url != null) {
				for (GrantedAuthority authority : userDetails.getAuthorities()) {
					if (url.getRoles().contains(authority.getAuthority())) {
						flag = true;
					}
				}
			} else {
				flag = true;
			}

			if (flag) {
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(token);
			}

		}

		filterChain.doFilter(request, response);
	}

}
