package com.cox.auto.dealerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cox.auto.dealerService.model.DataSet;

@Repository
public interface DataSetRepository extends JpaRepository<DataSet, String>{
	
	DataSet findByDataSetId(String dataSetId);

}
