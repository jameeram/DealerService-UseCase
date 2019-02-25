package com.cox.auto.dealerService.Service;

import com.cox.auto.dealerService.client.model.VehicleDTO;
import com.cox.auto.dealerService.model.DataSet;
import com.cox.auto.dealerService.model.Dealer;

public interface VehicleService {
	
	public void saveVehicle(VehicleDTO vehicleDTO, DataSet dataSet, Dealer dealer);

}
