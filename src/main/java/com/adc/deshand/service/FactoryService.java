package com.adc.deshand.service;

import java.util.List;

import com.adc.deshand.persist.entity.Factory;
import com.adc.deshand.service.dto.FactoryDTO;

public interface FactoryService extends GenericService<Factory, FactoryDTO, Integer> {

	List<FactoryDTO> findByCountryId(Integer country_id);

//	List<FactoryDTO> findByCountryName(String name);

}
