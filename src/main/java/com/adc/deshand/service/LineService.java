package com.adc.deshand.service;

import java.util.List;

import com.adc.deshand.persist.entity.Line;
import com.adc.deshand.service.dto.LineDTO;

public interface LineService extends GenericService<Line, LineDTO, Integer> {

	public List<LineDTO> findByFactory(Integer country_id);

}
