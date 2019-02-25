package com.cox.auto.dealerService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cox.auto.dealerService.client.model.VehicleDTO;
import com.cox.auto.dealerService.model.DataSet;
import com.cox.auto.dealerService.model.Dealer;
import com.cox.auto.dealerService.model.Vehicle;
import com.cox.auto.dealerService.model.VehicleIdentity;
import com.cox.auto.dealerService.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public void saveVehicle(VehicleDTO vehicleDTO, DataSet dataSet, Dealer dealer) {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(new VehicleIdentity(vehicleDTO.getVehicleId(), dataSet.getDataSetId(), dealer.getDealerId()));
		vehicle.setDataSet(dataSet);
		vehicle.setDealer(dealer);
		vehicle.setMake(vehicleDTO.getMake());
		vehicle.setModel(vehicleDTO.getModel());
		vehicle.setYear(vehicleDTO.getYear());
		vehicleRepository.save(vehicle);
	}
	

}
