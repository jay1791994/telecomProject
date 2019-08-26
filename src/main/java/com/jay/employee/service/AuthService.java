package com.jay.employee.service;

import com.jay.employee.request.UserData;

public interface AuthService {

	
	boolean registerUser(UserData userData);

	UserData getUserByUserName(String username);
}
