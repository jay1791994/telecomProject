package com.jay.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jay.employee.repo.AuthRepository;
import com.jay.employee.request.UserData;


@Service
public class AuthServiceImpl implements AuthService{

	
	@Autowired
	AuthRepository authRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	
	@Override
	public boolean registerUser(UserData userData) {
		
		
		              
        userData.setPassword(encoder.encode(userData.getPassword()));
		
		authRepo.insert(userData);
		
		return true;
	}

	@Override
	public UserData getUserByUserName(String username) {
		
	Optional<UserData> userData = 	authRepo.findById(username);	
	
	if(userData.isPresent()) {
		return userData.get();
	}else {
		return null;
	}
	
	
	}

}
