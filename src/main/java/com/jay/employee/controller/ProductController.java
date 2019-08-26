package com.jay.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.employee.request.Product;
import com.jay.employee.service.ProdcutService;

@RestController
@RequestMapping("api")
public class ProductController {
	
	
	
	@Autowired
	ProdcutService productService;
	
	@GetMapping("products")
	List<Product> getAllProducts(){
		
	 List<Product> productList = productService.findAllProducts();
		
	 return productList;
	}
	
	@GetMapping("product/{productId}")
	Product getProduct(@PathVariable String productId) {
		
		Product product = productService.getProductById(productId);
		return product;
	}
	
	@PostMapping("product")
	boolean createProduct(@RequestBody Product product) {
	
		boolean flag = productService.createProduct(product);
		return flag;
	}
	
	
	
	

}
