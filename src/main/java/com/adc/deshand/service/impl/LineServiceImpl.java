package com.adc.deshand.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Line;
import com.adc.deshand.persist.repo.LineRepo;
import com.adc.deshand.service.LineService;
import com.adc.deshand.service.dto.LineDTO;

@Service
public class LineServiceImpl extends GenericServiceImpl<Line, LineDTO, Integer> implements LineService {

	@Autowired
	private LineRepo repository;

	@Override
	public List<LineDTO> findByFactory(Integer factoryId) {
		List<LineDTO> result = new ArrayList<LineDTO>();
		for (Line line : repository.findByFactoryId(factoryId)) {
			result.add(mapper.map(line, dtoClass));
		}
		return result;
	}
}
