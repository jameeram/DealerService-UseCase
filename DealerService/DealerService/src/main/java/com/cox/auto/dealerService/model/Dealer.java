package com.cox.auto.dealerService.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name = "Dealer.findByDealerAndDataSet",
query = "SELECT e FROM Dealer e WHERE data_set_id =: dataSetId and dealer_id =: dealerId"
)
public class Dealer {

	
	@Id
	@Column(name="dealer_id")
	private Integer dealerId;
	
	@ManyToOne(targetEntity=DataSet.class, fetch= FetchType.LAZY)
	@JoinColumn(name ="data_set_id", nullable=false)
	@JsonBackReference
	private DataSet dataSet;
	
	@OneToMany(mappedBy = "dealer", targetEntity= Vehicle.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Vehicle> vehicles;
	
	public String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}
	

	public Dealer() {
		
	}
	
	public List<Vehicle> getVehicles() {
		if(vehicles == null) {
			vehicles = new ArrayList<Vehicle>();
		}
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dataSet=" + dataSet + ", vehicles=" + vehicles + ", name=" + name
				+ "]";
	}


	
}
