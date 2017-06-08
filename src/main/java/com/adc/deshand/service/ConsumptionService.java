package com.adc.deshand.service;

import java.util.List;

import com.adc.deshand.persist.entity.Consumption;
import com.adc.deshand.service.dto.ConsumptionDTO;

public interface ConsumptionService extends GenericService<Consumption, ConsumptionDTO, Integer>{
	
	List<ConsumptionDTO> findByMaterialId (Integer material_id);

}
