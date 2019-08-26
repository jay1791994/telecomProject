package com.jay.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.employee.request.OrderRequest;
import com.jay.employee.response.Order;
import com.jay.employee.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	
	
	@PostMapping("product")
	Order createOrder(@Valid @RequestBody OrderRequest order) {
		
		
		Order orderPlaced = orderService.createOrder(order.getUserName(), order.getProductOrPlanId());
		return  orderPlaced ;
		
	}
	
	
	

}
