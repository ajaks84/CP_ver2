package com.adc.deshand.persist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adc.deshand.persist.entity.Consumption;

public interface ConsumptionRepo extends JpaRepository<Consumption, Integer>{
	
	@Query("select cons from Consumption cons right outer join fetch cons.materialId mat where cons.reportId = ?1 ")
	List<Consumption> findByReportlId (Integer reportId);

	

	}


