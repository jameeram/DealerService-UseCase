package com.cox.auto.dealerService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VehicleIdentity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "vehicle_id", unique=true)
	private Integer vehicleId;

	@Column(name = "data_set_id")
	private String dataSetId;

	@Column(name = "dealer_id")
	private Integer dealerId;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getDataSetId() {
		return dataSetId;
	}

	public void setDataSetId(String dataSetId) {
		this.dataSetId = dataSetId;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vehicleId;
		result = prime * result + ((dealerId == null) ? 0 : dealerId.hashCode());
		result = prime * result + ((dataSetId == null) ? 0 : dataSetId.hashCode());
		return result;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleIdentity other = (VehicleIdentity) obj;
		if (vehicleId != other.vehicleId)
			return false;
		if (!dealerId.equals(other.dealerId))
			return false;
		if (!dataSetId.equals(other.dataSetId))
			return false;
		return false;
	}

	public VehicleIdentity(Integer vehicleId, String dataSetId, Integer dealerId) {
		super();
		this.vehicleId = vehicleId;
		this.dataSetId = dataSetId;
		this.dealerId = dealerId;
	}
	
	public VehicleIdentity() {
		
	}
}