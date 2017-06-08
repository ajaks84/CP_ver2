package com.adc.deshand.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Factory;
import com.adc.deshand.persist.repo.FactoryRepo;
import com.adc.deshand.service.FactoryService;
import com.adc.deshand.service.dto.FactoryDTO;

@Service
public class FactoryServiceImpl extends GenericServiceImpl<Factory, FactoryDTO, Integer> implements FactoryService {
	
	@Autowired
	private FactoryRepo repository;
	
	@Override
	  public List<FactoryDTO> findByCountryId(Integer countryId) { 
	    List<FactoryDTO> result = new ArrayList<FactoryDTO>();
	    for (Factory factory : repository.findByCountryId(countryId)) {
          result.add(mapper.map(factory, dtoClass));
      }
	    return result;
	  }
	
//	@Override
//	  public List<FactoryDTO> findByCountryName(String name) { 
//	    List<FactoryDTO> result = new ArrayList<FactoryDTO>();
//	    for (Factory factory : repository.findByCountryName(name)) {
//        result.add(mapper.map(factory, dtoClass));
//    }
//	    return result;
//	  }
	
//	This code is also working, but don't use it, cuz it's probably backward
	
//	@PersistenceContext
//	private EntityManager em;

//	@Override
//	  public List<FactoryDTO> findByCountry(Integer countryId) {
//	    TypedQuery<Factory> query = em.createQuery("select a from Factory a where a.countryId = ?1", Factory.class);
//	    query.setParameter(1, countryId);
//	    
//	    List<FactoryDTO> result = new ArrayList<FactoryDTO>();
//	    for (Factory factory : query.getResultList()) {
//          result.add(mapper.map(factory, dtoClass));
//      }
//	    return result;
//	  }
}
