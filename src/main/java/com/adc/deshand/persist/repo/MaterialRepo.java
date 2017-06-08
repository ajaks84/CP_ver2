package com.adc.deshand.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Material;

public interface MaterialRepo extends JpaRepository<Material, Integer> {

}
