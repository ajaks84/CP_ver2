package com.adc.deshand.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "line")
public class Line {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "product_id", nullable = false)
	private Integer productId;

	@Column(name = "speed", nullable = false)
	private Integer speed;

	@Column(name = "unit", nullable = false)
	private String unit;

	@Column(name = "capacity", nullable = false)
	private Integer capacity;

	@Column(name = "build_year", nullable = false)
	private Integer buildYear;

	@Column(name = "factory_id", nullable = false)
	private Integer factoryId;

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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(Integer buildYear) {
		this.buildYear = buildYear;
	}

	public Integer getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}

	@Override
	public String toString() {
		return "Line [id=" + id + ", name=" + name + ", productId=" + productId + ", speed=" + speed + ", unit=" + unit
				+ ", capacity=" + capacity + ", buildYear=" + buildYear + ", factoryId=" + factoryId + "]";
	}

}
