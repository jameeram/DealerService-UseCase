package com.cox.auto.dealerService.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name = "DataSet.findByDataSetId",
query = "SELECT e FROM DataSet e WHERE data_set_id =: dataSetId"
)
public class DataSet {
	
	@Id
	@GeneratedValue(generator = "DataSet_SEQ")
	@GenericGenerator (name = "DataSet_SEQ", strategy = "com.cox.auto.dealerService.model.DataSetIdGenerator")
	@Column(name="data_set_id")
	private String dataSetId;
	
	@OneToMany(mappedBy = "dataSet", targetEntity= Dealer.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Dealer> dealers;
	
	@OneToMany(mappedBy = "dataSet", targetEntity= Vehicle.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Vehicle> vehicles;

	public DataSet() {
		
	}

	public DataSet(String dataSetId) {
		super();
		this.dataSetId = dataSetId;
	}
	
	public String getDataSetId() {
		return dataSetId;
	}

	public void setDataSetId(String dataSetId) {
		this.dataSetId = dataSetId;
	}

	public List<Dealer> getDealers() {
		if(dealers == null) {
			dealers = new ArrayList<Dealer>();
		}
		return dealers;
	}

	public void setDealers(List<Dealer> dealers) {
		this.dealers = dealers;
	}

	public List<Vehicle> getVehicles() {
		if(vehicles == null) {
			vehicles = new ArrayList<Vehicle>();
		}
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vechicles) {
		this.vehicles = vechicles;
	}

	@Override
	public String toString() {
		return "DataSet [id=" + dataSetId + "]";
	}
	

}
