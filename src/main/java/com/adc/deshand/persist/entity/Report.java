package com.adc.deshand.persist.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "report")
public class Report {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "date", nullable = false)
	private Date date;
	@Column(name = "shift", nullable = false)
	private Integer shift;
	@Column(name = "register", nullable = false)
	private Integer register;
	@Column(name = "input", nullable = false)
	private Integer input;
	@Column(name = "output", nullable = false)
	private Integer output;
	@Column(name = "line_id", nullable = false)
	private Integer lineId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public Integer getInput() {
		return input;
	}

	public void setInput(Integer input) {
		this.input = input;
	}

	public Integer getOutput() {
		return output;
	}

	public void setOutput(Integer output) {
		this.output = output;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Integer getRegister() {
		return register;
	}

	public void setRegister(Integer register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", date=" + date + ", shift=" + shift + ", register=" + register + ", input="
				+ input + ", output=" + output + ", lineId=" + lineId + "]";
	}

}
