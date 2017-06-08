package com.adc.deshand.web.controller;

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

import com.adc.deshand.service.ConsumptionService;
import com.adc.deshand.service.dto.ConsumptionDTO;
import com.adc.deshand.service.dto.CountryDTO;
import com.adc.deshand.service.dto.FactoryDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/consumption")
public class ConsumptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumptionController.class);

	private String ctrlName = this.getClass().getSimpleName();

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private ConsumptionService service;

//	@RequestMapping(value = "/by{reportId}", method = RequestMethod.GET)
//	public ResponseEntity<List<ConsumptionWithMateialModel>> getByReportId(@PathVariable("reportId") Integer reportId) {
//		List<ConsumptionWithMaterial> all = service.getByReportId(reportId);
//		LOGGER.info(ctrlName + all);
//		List<ConsumptionWithMateialModel> converted = new ArrayList<>();
//		for (ConsumptionWithMaterial cons : all) {
//			converted.add(entity2model(cons));
//		}
//		return new ResponseEntity<List<ConsumptionWithMateialModel>>(converted, HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/by{material_id}", method = RequestMethod.GET)
	public @ResponseBody List<ConsumptionDTO> getByCountry(@PathVariable("material_id") Integer material_id) {
		
//		System.out.println(service.findByMaterialId(material_id));
		return service.findByMaterialId(material_id);
		
//		return null;
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody List<ConsumptionDTO> getAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ConsumptionDTO getById(@PathVariable("id") Integer id) {
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ConsumptionDTO consModel) {
		LOGGER.info(ctrlName + consModel);
		service.save(consModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{consId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer consId) {
		service.delete(consId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
