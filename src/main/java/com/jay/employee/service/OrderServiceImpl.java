package com.jay.employee.service;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.employee.repo.OrderRepository;
import com.jay.employee.repo.ProductRepository;
import com.jay.employee.request.Product;
import com.jay.employee.response.Order;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderRepository orderRepo;

	
	@Override
	public Order createOrder(String userId, String productId) {
	
		System.out.println("came here");
		Optional<Product> product = productRepo.findById(productId);
		
		Order order = new Order();
		
		if(product.isPresent()) {
			order.setObject(product.get());
			order.setUserEmail(userId);
			order.setOrderId(getRandomId());
			Order orderRes = orderRepo.insert(order);
			System.out.println();
			return orderRes;
		}
		else {
			return  null;
		}
		
	
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
			
			idPresent = orderRepo.existsById(generatedId);
			
			
			}
			
			return generatedId;
			
	   }
}

