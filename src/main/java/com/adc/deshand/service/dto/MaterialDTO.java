package com.adc.deshand.service.dto;

import java.util.List;

import org.dozer.Mapping;

import com.adc.deshand.persist.entity.Consumption;

public class MaterialDTO {

	@Mapping("id")
	private Integer id;

	@Mapping("name")
	private String name;

	@Mapping("unit")
	private String unit;

	@Mapping("deleted")
	private Boolean deleted;
	
	private List<Consumption> consumption;


	public List<Consumption> getConsumption() {
		return consumption;
	}

	public void setConsumption(List<Consumption> consumption) {
		this.consumption = consumption;
	}

	public Integer getId() {
		// System.out.println("getId");
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		// System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		// System.out.println("getUnit");
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Boolean getDeleted() {
		// System.out.println("getDeleted");
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", unit=" + unit + ", deleted=" + deleted + "]";
	}

}
