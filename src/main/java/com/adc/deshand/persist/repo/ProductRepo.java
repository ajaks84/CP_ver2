package com.adc.deshand.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.persist.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
