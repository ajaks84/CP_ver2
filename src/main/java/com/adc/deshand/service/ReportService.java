package com.adc.deshand.service;

import java.sql.Date;
import java.util.List;

import com.adc.deshand.persist.entity.Report;
import com.adc.deshand.service.dto.ReportDTO;

public interface ReportService extends GenericService<Report, ReportDTO, Integer>{
	
	List<ReportDTO> findByLineIdAndDate(Integer line_id, Date date);
	
	ReportDTO getSingleReport(Integer line_id, Date date, Integer shift);

}
