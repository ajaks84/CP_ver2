package com.adc.deshand.service.impl;

import org.springframework.stereotype.Service;

import com.adc.deshand.persist.entity.Material;
import com.adc.deshand.service.MaterialService;
import com.adc.deshand.service.dto.MaterialDTO;

@Service
public class MaterialServiceImpl extends GenericServiceImpl<Material, MaterialDTO, Integer> implements MaterialService {

}
