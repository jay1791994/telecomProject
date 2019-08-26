package com.jay.employee.request;

import javax.validation.constraints.NotNull;

public class OrderRequest {
	
	
	
	@NotNull
	private String userName;
	
	@NotNull
	private String productOrPlanId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductOrPlanId() {
		return productOrPlanId;
	}
	public void setProductOrPlanId(String productOrPlanId) {
		this.productOrPlanId = productOrPlanId;
	}

}
