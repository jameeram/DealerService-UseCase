package com.cox.auto.dealerService.client.model;

public class VehicleResponse {
	
	
	private Integer vehicleId;
	
	private Integer dealerId;
	
	private Integer year;
	
	private String make;
	
	private String model;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "VehicleResponse [vehicleId=" + vehicleId + ", dealerId=" + dealerId + ", year=" + year + ", make="
				+ make + ", model=" + model + "]";
	}
	

}
