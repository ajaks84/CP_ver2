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

import com.adc.deshand.service.LineService;
import com.adc.deshand.service.dto.FactoryDTO;
import com.adc.deshand.service.dto.LineDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/lines")
public class LineController {

	private static final Logger logger = LoggerFactory.getLogger(LineController.class);

	private String ctrlName = this.getClass().getSimpleName();

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private LineService service;

	@RequestMapping(value = "/by{factoryId}", method = RequestMethod.GET)
	public @ResponseBody List<LineDTO> getByFactory(@PathVariable("factoryId") Integer factoryId) {
		logger.info("get json factory by country list");
		return service.findByFactory(factoryId);
	}
	
	@RequestMapping(value = "/{factoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer factoryId) {
		service.delete(factoryId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody LineDTO lineModel) {
		service.save(lineModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<LineModel>> getAll() {
//		List<Line> all = service.getAll();
//		LOGGER.error(ctrlName + all);
//		List<LineModel> converted = new ArrayList<>();
//		for (Line line : all) {
//			converted.add(entity2model(line));
//		}
//		return new ResponseEntity<List<LineModel>>(converted, HttpStatus.OK);
//	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<LineModel> getById(@PathVariable Integer id) {
//		Line line = service.get(id);
//		return new ResponseEntity<LineModel>(entity2model(line), HttpStatus.OK);
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> save(@RequestBody LineModel lineModel) {
//		LOGGER.error(ctrlName + lineModel);
//		service.save(model2entity(lineModel));
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//
//	}
//
//	@RequestMapping(value = "/{lineId}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer lineId) {
//		service.delete(lineId);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//
//	}



}
