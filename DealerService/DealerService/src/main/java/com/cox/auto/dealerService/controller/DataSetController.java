package com.cox.auto.dealerService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cox.auto.dealerService.Service.DealerService;
import com.cox.auto.dealerService.client.model.AnswerResponse;
import com.cox.auto.dealerService.client.model.DataSetDTO;
import com.cox.auto.dealerService.client.model.DatasetIdResponse;
import com.cox.auto.dealerService.model.DataSet;
import com.cox.auto.dealerService.repository.DataSetRepository;
import com.cox.auto.dealerService.util.DealerServicesUtil;

@RestController
@RequestMapping("/api")
public class DataSetController {
	
	
	@Autowired
	DealerService dealerService;
	
	@Autowired
	DataSetRepository dataSetRepository;
	
	@GetMapping("/datasetId")
	public DatasetIdResponse creaateDataSet() {
		DatasetIdResponse dataSetReponse = new DatasetIdResponse();
		DataSet dataSet = dataSetRepository.save(new DataSet());
		if(dataSet!=null) {
			dataSetReponse.setDataSetId(dataSet.getDataSetId());
		}
		return dataSetReponse;
	}
	
	@GetMapping("/{datasetId}/cheat")
	public DataSetDTO retrieveDataSet(@PathVariable String datasetId) {
		DataSet dataSet = dataSetRepository.findByDataSetId(datasetId);
		return DealerServicesUtil.convertResultsToDataSetDTO(dataSet);
	}
	
	@PostMapping("/{dataSetId}/answer")
	public AnswerResponse createAnswer(@PathVariable String dataSetId, 
			@Valid @RequestBody DataSetDTO dataSetDTO) {
		long startTime = System.nanoTime();
		dealerService.saveDealer(dataSetId, dataSetDTO);
		long endTime = System.nanoTime();
		AnswerResponse answerResponse = new AnswerResponse();
			answerResponse.setMessage("Successfully Created");
			answerResponse.setSuccess(true);
			answerResponse.setTotalMilliseconds(endTime - startTime);
		return answerResponse;
	}
	
	
	
}
