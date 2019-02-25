package com.cox.auto.dealerService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cox.auto.dealerService.client.model.VehicleResponse;
import com.cox.auto.dealerService.model.Vehicle;
import com.cox.auto.dealerService.repository.DataSetRepository;
import com.cox.auto.dealerService.repository.DealerRepository;
import com.cox.auto.dealerService.repository.VehicleRepository;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	DealerRepository dealerRepository;
	
	@Autowired
	DataSetRepository dataSetRepository;
	
	
	@GetMapping("/{dataSetId}/vehicles")
	public List<Integer> retrieveVehicleByDataSet(@PathVariable final String dataSetId) {
		List<Vehicle> vehicles = vehicleRepository.findByDataSetId(dataSetId);
		List<Integer> vehicleIds = new ArrayList<Integer>();
		for(Vehicle vehicle : vehicles) {
			vehicleIds.add(vehicle.getId().getVehicleId());
		}
		return vehicleIds;
	}
	
	@GetMapping("/{dataSetId}/vehicles/{vehicleId}")
	public VehicleResponse retrieveVehicleByDataSet(@PathVariable final String dataSetId, 
			@PathVariable final String vehicleId) {
		return createVehicleResponse(vehicleRepository.findByVehicleAndDataSet(dataSetId, Integer.valueOf(vehicleId)));
	}
	
	
	private VehicleResponse createVehicleResponse(Vehicle vehicle) {
		
		VehicleResponse vehicleResponse = new VehicleResponse();
		if(vehicle!=null) {
			vehicleResponse.setDealerId(vehicle.getDealer().getDealerId());
			vehicleResponse.setMake(vehicle.getMake());
			vehicleResponse.setModel(vehicle.getModel());
			vehicleResponse.setYear(vehicle.getYear());
			vehicleResponse.setVehicleId(vehicle.getId().getVehicleId());
		}
		
		return vehicleResponse;
	}

}
