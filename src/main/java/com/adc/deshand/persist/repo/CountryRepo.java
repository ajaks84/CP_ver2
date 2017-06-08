package com.adc.deshand.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Country;


public interface CountryRepo extends JpaRepository<Country, Integer> {
	
}
