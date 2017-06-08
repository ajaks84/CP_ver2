package com.adc.deshand.service.dto;

import java.sql.Date;

import org.dozer.Mapping;

public class ReportDTO {
	
	@Mapping("id")
    private Integer id;
	@Mapping("date")
    private Date date; 
	@Mapping("shift")
    private Integer shift;
	@Mapping("register")
    private Integer register;
	@Mapping("input")
    private Integer input;
	@Mapping("output")
    private Integer output;
	@Mapping("lineId")
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
