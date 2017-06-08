package com.adc.deshand.service.impl;

import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Product;
import com.adc.deshand.service.ProductService;
import com.adc.deshand.service.dto.ProductDTO;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductDTO, Integer> implements ProductService {

}
