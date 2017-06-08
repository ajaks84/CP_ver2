package com.adc.deshand.service.dto;

import org.dozer.Mapping;

public class CountryDTO {
	
    @Mapping("id")
	private Integer id;
    @Mapping("name")
    private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer authorId) {
		this.id = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	} 
	
	
    
    

}
