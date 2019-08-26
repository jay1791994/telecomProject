package com.jay.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.employee.request.UserData;
import com.jay.employee.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	
	
	@Autowired
	AuthService authService;
	
	@PostMapping("register")
	boolean registerTheUser(@Valid @RequestBody UserData userData ) {
	
		this.authService.registerUser(userData);
		return  true;
	}

}
