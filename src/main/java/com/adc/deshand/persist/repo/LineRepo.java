package com.adc.deshand.persist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Line;

public interface LineRepo extends JpaRepository<Line, Integer> {

	List<Line> findByFactoryId(Integer id);

}
