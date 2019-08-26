package com.jay.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.employee.repo.ProductRepository;
import com.jay.employee.request.Product;


@Service
public class ProductServiceImpl implements ProdcutService {
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(String productId) {
		
		Optional<Product> productResponse = productRepo.findById(productId);
		
	    if(productResponse.isPresent()) {
	    	return productResponse.get();
	    }else {
	    	return null;
	    }
		
	}

	@Override
	public boolean createProduct(Product product) {
		
	product.setProductId(getRandomId());
     Product productReturned =	productRepo.insert(product);
		
     if(productReturned != null) {
    	 return true;
     }
     
     return false;
	}
	
 public  String getRandomId() {
		
		Random random = new Random();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@%";
		boolean idPresent = true;
		StringBuilder idBuilder = new StringBuilder("");
		String generatedId = null;
		while(idPresent) {
		for(int i=0 ; i < 10 ; i++) {
			idBuilder.append(letters.charAt(random.nextInt(letters.length())));
		}
		generatedId = idBuilder.toString();
		
		idPresent = productRepo.existsById(generatedId);
		
		
		}
		
		return generatedId;
		
   }

}
