package com.jay.employee.service;

import com.jay.employee.response.Order;

public interface OrderService {
	
	Order createOrder(String userId, String productId);

}
