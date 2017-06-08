package com.adc.deshand.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "consumption")
public class Consumption {

	private Integer id;
	private Integer reportId;
	private Material material;
	private Double quantity;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "report_id", nullable = false)
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="material_id",insertable = false, updatable = false)
	public Material getMaterialId() {
		return material;
	}

	public void setMaterialId(Material material) {
		this.material = material;
	}
	
	@Column(name = "quantity", nullable = false)
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Consumption [id=" + id + ", reportId=" + reportId + ", material=" + material + ", quantity="
				+ quantity + "]";
	}

}
