package com.cox.auto.dealerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cox.auto.dealerService.client.model.DealerResponse;
import com.cox.auto.dealerService.model.Dealer;
import com.cox.auto.dealerService.repository.DataSetRepository;
import com.cox.auto.dealerService.repository.DealerRepository;

@RestController
@RequestMapping("/api")
public class DealerController {

	
	@Autowired
	DealerRepository dealerRepository;
	
	@Autowired
	DataSetRepository dataSetRepository;
	
	
	@GetMapping("/{datasetId}/dealers/{dealerid}")
	public DealerResponse retrieveDealerByDataSet(@PathVariable("datasetId") final String dataSetId, 
			@PathVariable("dealerid") final String dealerId) {
		return createDealerResponse(dealerRepository.findByDealerAndDataSet(dataSetId, Integer.valueOf(dealerId)));
	}
	
	
	private DealerResponse createDealerResponse(Dealer dealer) {
		DealerResponse dealerResponse = new DealerResponse();
		if(dealer!=null) {
			dealerResponse.setDealerId(dealer.getDealerId());
			dealerResponse.setName(dealer.getName());
		}
		return dealerResponse;
	}
	
}
