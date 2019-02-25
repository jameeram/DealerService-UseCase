package com.cox.auto.dealerService.client.model;

import java.util.ArrayList;
import java.util.List;

public class DealerDTO {
	
	private Integer dealerId;
	
	private String name;

	List<VehicleDTO> vehicles;

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
	
	public List<VehicleDTO> getVehicles() {
		if(vehicles == null) {
			vehicles = new ArrayList<VehicleDTO>();
		}
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

}
