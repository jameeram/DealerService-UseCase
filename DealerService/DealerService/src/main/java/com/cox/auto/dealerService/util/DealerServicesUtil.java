package com.cox.auto.dealerService.util;

import com.cox.auto.dealerService.client.model.DataSetDTO;
import com.cox.auto.dealerService.client.model.DealerDTO;
import com.cox.auto.dealerService.client.model.VehicleDTO;
import com.cox.auto.dealerService.model.DataSet;
import com.cox.auto.dealerService.model.Dealer;
import com.cox.auto.dealerService.model.Vehicle;

public class DealerServicesUtil {

	public static DataSetDTO convertResultsToDataSetDTO(DataSet dataSet) {

		DataSetDTO dataSetDTO = new DataSetDTO();
		if (dataSet != null) {
			DealerDTO dealerDTO = null;
			for (Dealer dealer : dataSet.getDealers()) {
				dealerDTO = new DealerDTO();
				dealerDTO.setDealerId(dealer.getDealerId());
				dealerDTO.setName(dealer.getName());
				VehicleDTO vehicleDTO = null;
				for (Vehicle vehicle : dealer.getVehicles()) {
					vehicleDTO = new VehicleDTO();
					vehicleDTO.setVehicleId(vehicle.getId().getVehicleId());
					vehicleDTO.setMake(vehicle.getMake());
					vehicleDTO.setModel(vehicle.getModel());
					vehicleDTO.setYear(vehicle.getYear());
					dealerDTO.getVehicles().add(vehicleDTO);
				}
				dataSetDTO.getDealers().add(dealerDTO);
			}

		}

		return dataSetDTO;
	}

}
