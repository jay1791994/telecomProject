package com.jay.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.employee.repo.PlanRepository;
import com.jay.employee.request.Plan;

@Service
public class PlanServiceImpl implements PlanService{
	
	
	@Autowired
	PlanRepository planRepo;

	@Override
	public List<Plan> findAllPlans() {
		List<Plan> planList = planRepo.findAll();
		
		return planList;
	}

	@Override
	public Plan getPlanById(String planId) {
	
		Optional<Plan> planData = planRepo.findById(planId);
		if(planData.isPresent()){
			
			return planData.get();
		}else {
			return null;
		}
		
	}

	@Override
	public boolean createPlan(Plan plan) {
		
		plan.setPlanId(this.getRandomId());
		Plan planRes   =  planRepo.insert(plan);
        if(planRes != null) {
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
		
		idPresent = planRepo.existsById(generatedId);
		
		
		}
		
		return generatedId;
		
   }
	
}
