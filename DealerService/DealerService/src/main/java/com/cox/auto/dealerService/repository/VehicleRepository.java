package com.cox.auto.dealerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cox.auto.dealerService.model.Vehicle;
import com.cox.auto.dealerService.model.VehicleIdentity;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, VehicleIdentity>{
	
	Vehicle findByVehicleAndDataSet(String dataSetId, Integer vehicleId);
	
	List<Vehicle> findByDataSetId(String dataSetId);

}
