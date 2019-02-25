package com.cox.auto.dealerService.Service;

import com.cox.auto.dealerService.client.model.DataSetDTO;

public interface DealerService {

	public void saveDealer(String dataSetId, DataSetDTO dataSetDTO);
	
}
