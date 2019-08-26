package com.jay.employee.service;

import java.util.List;

import com.jay.employee.request.Product;

public interface ProdcutService {

	List<Product> findAllProducts();

	Product getProductById(String productId);

	boolean createProduct(Product product);

}
