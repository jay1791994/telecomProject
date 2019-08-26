package com.jay.employee.request;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Plan {
	
	
	
	@Id
	@Field("planId")
	String planId;
	String planName;
	String internetData;
	boolean internationalCallFree;
	double price;
		
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getInternetData() {
		return internetData;
	}
	public void setInternetData(String internetData) {
		this.internetData = internetData;
	}
	public boolean isInternationalCallFree() {
		return internationalCallFree;
	}
	public void setInternationalCallFree(boolean internationalCallFree) {
		this.internationalCallFree = internationalCallFree;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
		
	
}
