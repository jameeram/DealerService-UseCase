package com.cox.auto.dealerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cox.auto.dealerService.model.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer>{
	

	Dealer findByDealerAndDataSet(String dataSetId, Integer dealerId);
	
	Dealer findByDataSet(String dataSetId);
	
}
