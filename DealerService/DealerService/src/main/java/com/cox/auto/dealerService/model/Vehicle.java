package com.cox.auto.dealerService.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@NamedQuery(name = "Vehicle.findByVehicleAndDataSet",
        query = "SELECT e FROM Vehicle e WHERE data_set_id =: dataSetId and vehicle_id =: vehicleId"
)
@NamedQuery(name = "Vehicle.findByDataSetId",
	query = "SELECT e FROM Vehicle e WHERE data_set_id =: dataSetId"
)
public class Vehicle {
	
	@EmbeddedId
	private VehicleIdentity id;

	@MapsId("dataSetId")
	@ManyToOne(targetEntity = DataSet.class, fetch = FetchType.LAZY)
	@JoinColumn(name="data_set_id", insertable=false, updatable=false, nullable=false)
	@JsonBackReference
	private DataSet dataSet;

	@MapsId("dealerId")
	@ManyToOne(targetEntity = Dealer.class, fetch = FetchType.LAZY)
	@JoinColumn(name="dealer_id", insertable=false, updatable=false, nullable=false)
	@JsonBackReference
	private Dealer dealer;
	
	private Integer year;
	
	private String make;
	
	private String model;

	
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
	
	public VehicleIdentity getId() {
		return id;
	}

	public void setId(VehicleIdentity id) {
		this.id = id;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	public Vehicle() {
    	
    }

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", dataSet=" + dataSet + ", dealer=" + dealer + ", year=" + year + ", make=" + make
				+ ", model=" + model + "]";
	}

	
	
}
