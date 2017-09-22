package com.book.security.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.book.user.domain.model.User;
import com.book.user.domain.repository.UserRepository;

@Service
public class AuthUserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("根据用户名找到用户");
		}
		AuthUser userDetail = new AuthUser();
		userDetail.setId(user.getId());
		userDetail.setPassword(user.getPassword());
		userDetail.setUsername(user.getUserName());
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		for (String role : user.getRoles()) {
			simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
		}
		userDetail.setAuthorities(simpleGrantedAuthorities);

		return userDetail;
	}

}
