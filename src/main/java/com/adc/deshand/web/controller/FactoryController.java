package com.adc.deshand.web.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adc.deshand.service.FactoryService;
import com.adc.deshand.service.dto.FactoryDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/Factories")
public class FactoryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private FactoryService service;

	@Autowired
	private MessageSource ms;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<FactoryDTO> getAll() {
		logger.debug("get json factory list");
		return service.findAll();

	}

	// @RequestMapping(value = "/factories/by{id}", method = RequestMethod.GET)
	// public @ResponseBody FactoryDTO getById(@PathVariable("id") Integer id) {
	// logger.debug("get json factory by id");
	// logger.info(factoryService.findOne(id).toString());
	//
	// return factoryService.findOne(id);
	// }

	@RequestMapping(value = "/by{countryId}", method = RequestMethod.GET)
	public @ResponseBody List<FactoryDTO> getByCountry(@PathVariable("countryId") Integer countryId) {
		return service.findByCountryId(countryId);
	}

//	@RequestMapping(value = "/{countryName}", method = RequestMethod.GET)
//	public @ResponseBody List<FactoryDTO> getByCountryName(@PathVariable String countryName) {
//		return service.findByCountryName(countryName);
//	}

	@RequestMapping(value = "/{factoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer factoryId) {
		service.delete(factoryId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody FactoryDTO factoryModel) {
		// LOGGER.error(ctrlName + factoryModel);
		service.save(factoryModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
