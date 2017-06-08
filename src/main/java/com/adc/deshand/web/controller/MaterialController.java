package com.adc.deshand.web.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adc.deshand.persist.entity.Material;
import com.adc.deshand.service.MaterialService;
import com.adc.deshand.service.dto.MaterialDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private MaterialService service;

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<MaterialModel> getById(@PathVariable("id") Integer id) {
//		Material material = service.get(id);
//		return new ResponseEntity<MaterialModel>(entity2model(material), HttpStatus.OK);
//	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody MaterialDTO getById(@PathVariable Integer id) {
		return service.findOne(id);
	}

}