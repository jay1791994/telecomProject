package com.jay.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.employee.request.Plan;
import com.jay.employee.request.Product;
import com.jay.employee.service.PlanService;

@RestController
@RequestMapping("api")
public class PlanContoller {
	
	
	@Autowired
    PlanService planService;
	
	@GetMapping("plans")
	List<Plan> getAllPlans(){
		
	 List<Plan> productList = planService.findAllPlans();
		
	 return productList;
	}
	
	@GetMapping("plan/{planId}")
	Plan getPlan(@PathVariable String planId) {
		
		Plan plan = planService.getPlanById(planId);
		return plan;
	}
	
	@PostMapping("plan")
	boolean createPlan(@RequestBody Plan plan) {
		
		boolean flag = planService.createPlan(plan);
		return flag;
	}
	
	
	
	

}
