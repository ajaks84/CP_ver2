package com.adc.deshand.service.dto;

import org.dozer.Mapping;

import com.adc.deshand.persist.entity.Material;

public class ConsumptionDTO {

	@Mapping("id")
	private Integer id;
	@Mapping("reportId")
	private Integer reportId;
	@Mapping("material")
	private Material material;
	@Mapping("quantity")
	private Double quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "ConsumptionDTO [id=" + id + ", reportId=" + reportId + ", material=" + material + ", quantity="
				+ quantity + "]";
	}



}
