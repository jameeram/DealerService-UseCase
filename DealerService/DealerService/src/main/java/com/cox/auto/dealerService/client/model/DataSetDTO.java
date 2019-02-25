package com.cox.auto.dealerService.client.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cox.auto.dealerService.model.Dealer;
import com.cox.auto.dealerService.model.Vehicle;

public class DataSetDTO {
	
	
	List<DealerDTO> dealers;
	
	

	public DataSetDTO() {
		
	}

	public List<DealerDTO> getDealers() {
		if(dealers == null) {
			dealers = new ArrayList<DealerDTO>();
		}
		return dealers;
	}

	public void setDealers(List<DealerDTO> dealers) {
		this.dealers = dealers;
	}

	


}
