package com.adc.deshand.persist.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>{
	
	List<Report> findByLineIdAndDate(Integer line_id, Date date);
	
	Report findByLineIdAndDateAndShift(Integer line_id, Date date, Integer shift);


}
