package com.adc.deshand.service.dto;

import org.dozer.Mapping;

public class FactoryDTO {

	@Mapping("id")
	private Integer id;
	@Mapping("name")
	private String name;
	@Mapping("countryId")
	private Integer countryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Factory [id=" + id + ", name=" + name + ", countryId=" + countryId + "]";
	}

}
