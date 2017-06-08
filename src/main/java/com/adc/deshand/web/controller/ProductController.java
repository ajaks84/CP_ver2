package com.adc.deshand.web.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adc.deshand.service.ProductService;
import com.adc.deshand.service.dto.ProductDTO;

@Controller
@Scope("request")
@SuppressWarnings("unused")
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private ProductService service;
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<ProductModel> getById(@PathVariable Integer id) {
//		Product product = service.get(id);
//		return new ResponseEntity<ProductModel>(entity2model(product), HttpStatus.OK);
//	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public @ResponseBody ProductDTO getById(@PathVariable Integer id) {
			return service.findOne(id);
		}

}
