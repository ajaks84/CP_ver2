package com.adc.deshand.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, D, ID extends Serializable>{
    
    D findOne(ID id);
    
    List<D> findAll();
    
    void save(D dto);
    
    void delete(ID id);


}
