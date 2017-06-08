package com.adc.deshand.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Consumption;
import com.adc.deshand.persist.repo.ConsumptionRepo;
import com.adc.deshand.service.ConsumptionService;
import com.adc.deshand.service.dto.ConsumptionDTO;

@Service
public class ConsumptionServiceImpl extends GenericServiceImpl<Consumption, ConsumptionDTO, Integer>
		implements ConsumptionService {

	@Autowired
	private ConsumptionRepo repository;

	@Override
	public List<ConsumptionDTO> findByMaterialId(Integer material_id) {

		List<ConsumptionDTO> result = new ArrayList<ConsumptionDTO>();
		List<Consumption> c = repository.findByReportlId(material_id);

		for (Consumption consumption : c) {
//			System.out.println(consumption.toString());
			result.add(mapper.map(consumption, dtoClass));
		}

		// repository.findByReportlId(material_id);
		// List<Consumption> res = new ArrayList<Consumption>();

		// List<ConsumptionDTO> result = new ArrayList<ConsumptionDTO>();
		// for (Consumption consumption :
		// repository.findByReportlId(material_id)) {
		// result.add(mapper.map(consumption, dtoClass));
		// }

		return result;
	}

	// @PersistenceContext
	// private EntityManager em;
	//
	// @Override
	// public List<ConsumptionDTO> findByMaterialId(Integer countryId) {
	// TypedQuery<Consumption> query = em.createQuery("select cons.quantity,
	// cons.reportId from Consumption cons right outer join cons.material mat
	// where cons.id = ?1 ", Consumption.class);
	// query.setParameter(1, countryId);
	//
	// List<ConsumptionDTO> result = new ArrayList<ConsumptionDTO>();
	// for (Consumption factory : query.getResultList()) {
	// result.add(mapper.map(factory, dtoClass));
	// }
	// return result;
	// }

}
