package com.cox.auto.dealerService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cox.auto.dealerService.client.model.DataSetDTO;
import com.cox.auto.dealerService.client.model.DealerDTO;
import com.cox.auto.dealerService.client.model.VehicleDTO;
import com.cox.auto.dealerService.model.DataSet;
import com.cox.auto.dealerService.model.Dealer;
import com.cox.auto.dealerService.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService{
	
	@Autowired
	DealerRepository dealerRepository;
	
	@Autowired
	VehicleService vehcileService;

	@Override
	public void saveDealer(String dataSetId, DataSetDTO dataSetDTO) {
		
		DataSet dataSet = new DataSet();
		dataSet.setDataSetId(dataSetId);
		
		//dealers
		Dealer dealer = null;
		for(DealerDTO dealerDTO : dataSetDTO.getDealers()) {
			dealer = new Dealer();
			dealer.setDealerId(dealerDTO.getDealerId());
			dealer.setName(dealerDTO.getName());	
			dealer.setDataSet(dataSet);
			dealerRepository.save(dealer);
			for(VehicleDTO vehicleDTO : dealerDTO.getVehicles()) {
				vehcileService.saveVehicle(vehicleDTO, dataSet, dealer);
			}
		}
			
	}
	
	

}
