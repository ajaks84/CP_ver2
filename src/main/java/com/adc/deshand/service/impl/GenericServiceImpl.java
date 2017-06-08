package com.adc.deshand.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.adc.deshand.service.GenericService;

public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    protected DozerBeanMapper mapper;

    protected Class<T> entityClass;

    protected Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    public D findOne(ID id) {
//    	System.out.println(repository.getOne(id).getClass().getSimpleName());
//        return null;
    	return mapper.map(repository.findOne(id), dtoClass);
    }

    public List<D> findAll() {
        List<D> result = new ArrayList<D>();
        for (T t : repository.findAll()) {
        	
            result.add(mapper.map(t, dtoClass));
        }
        return result;
    }
    
    public void delete (ID id){
    	repository.delete(id);
    }
    
    public void save(D dto) {
        repository.saveAndFlush(mapper.map(dto, entityClass));
    }
    

    


}
