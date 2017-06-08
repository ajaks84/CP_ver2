package com.adc.deshand.persist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Factory;

public interface FactoryRepo extends JpaRepository<Factory, Integer> {
	
	List<Factory> findByCountryId(Integer id);
//	List<Factory> findByCountryName(String name);

}