package com.jay.employee.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jay.employee.request.UserData;

@Service
public class UserDetailProvider  implements UserDetailsService{

	@Autowired
	AuthService authService ;
	
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		System.out.println(username);
		UserData userData = authService.getUserByUserName(username);
		
		if(userData == null) {
				System.out.println("exception thrown");
			throw new UsernameNotFoundException("User Not Found");
		}
		
		String encodedPassword = userData.getPassword();
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		
		System.out.println("user not returned");
		return new User(username,encodedPassword, authorities);
		
	}

}
