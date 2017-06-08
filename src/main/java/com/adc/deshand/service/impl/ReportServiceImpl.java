package com.adc.deshand.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Report;
import com.adc.deshand.persist.repo.ReportRepo;
import com.adc.deshand.service.ReportService;
import com.adc.deshand.service.dto.ReportDTO;

@Service
public class ReportServiceImpl extends GenericServiceImpl<Report, ReportDTO, Integer> implements ReportService {

	@Autowired
	private ReportRepo repository;

	@Override
	public List<ReportDTO> findByLineIdAndDate(Integer line_id, Date date) {
		List<ReportDTO> result = new ArrayList<ReportDTO>();
		for (Report report : repository.findByLineIdAndDate(line_id, date)) {
			result.add(mapper.map(report, dtoClass));
		}
		return result;
	}

	@Override
	public ReportDTO getSingleReport(Integer line_id, Date date, Integer shift) {
		Report result = repository.findByLineIdAndDateAndShift(line_id, date, shift);
		if (result == null)  return null;
		return mapper.map(result, dtoClass);
	}

}
