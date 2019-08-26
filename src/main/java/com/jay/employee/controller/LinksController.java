package com.jay.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("link")
public class LinksController {
	
	
	
	@GetMapping("data")
	@Secured("ROLE_USER")
	List<String> getLinks() {
		
	  List<String> linkList = new ArrayList<String>();
	  linkList.add("products");
	  linkList.add("Plans");
	 
	  
	  return linkList;
	}

}
