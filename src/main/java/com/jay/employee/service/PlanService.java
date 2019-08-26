package com.jay.employee.service;

import java.util.List;

import com.jay.employee.request.Plan;
import com.jay.employee.request.Product;

public interface PlanService {

	List<Plan> findAllPlans();

	

	Plan getPlanById(String planId);



	boolean createPlan(Plan plan);


}
