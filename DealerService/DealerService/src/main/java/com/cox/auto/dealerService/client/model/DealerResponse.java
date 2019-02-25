package com.cox.auto.dealerService.client.model;

public class DealerResponse {
	
	
	private Integer dealerId;
	
	private String name;

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DealerResponse [dealerId=" + dealerId + ", name=" + name + "]";
	}
	
}
