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

import com.adc.deshand.service.CountryService;
import com.adc.deshand.service.dto.CountryDTO;
import com.adc.deshand.service.dto.FactoryDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/countries")
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private CountryService service;

    @Autowired
    private MessageSource ms;

   
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CountryDTO> countryList() {
        logger.debug("get json user list");
        return service.findAll();
    }
    
    @RequestMapping(value = "/{countryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer countryId) {
		service.delete(countryId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody CountryDTO countryModel) {
//		LOGGER.error(ctrlName + factoryModel);
		service.save(countryModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

    
}

 
