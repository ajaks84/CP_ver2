package com.adc.deshand.web.controller;

import java.sql.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adc.deshand.persist.entity.Report;
import com.adc.deshand.service.ReportService;
import com.adc.deshand.service.dto.ReportDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/reports")
public class ReportController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

	private String ctrlName = this.getClass().getSimpleName();

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private ReportService service;

	@RequestMapping(value = "/by{lineId}/{reportDate}/{shift}", method = RequestMethod.GET)
	public @ResponseBody ReportDTO getSingleShiftReport(@PathVariable("lineId") Integer lineId,
			@PathVariable("reportDate") Date reportDate, @PathVariable("shift") Integer shift) {
		return service.getSingleReport(lineId, reportDate, shift);
	}

	@RequestMapping(value = "/by{lineId}/{reportDate}", method = RequestMethod.GET)
	public @ResponseBody List<ReportDTO> getShiftsByLineAndDate(@PathVariable("lineId") Integer lineId,
			@PathVariable("reportDate") Date reportDate) {
		return service.findByLineIdAndDate(lineId, reportDate);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ReportDTO reportModel) {
		service.save(reportModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{reportId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer reportId) {
		service.delete(reportId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
