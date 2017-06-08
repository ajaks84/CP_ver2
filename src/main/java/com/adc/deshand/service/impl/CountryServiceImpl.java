package com.adc.deshand.service.impl;

import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Country;
import com.adc.deshand.service.CountryService;
import com.adc.deshand.service.dto.CountryDTO;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country, CountryDTO, Integer> implements CountryService {


}
