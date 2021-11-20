package com.robot.model;

import java.util.Date;

public class Robot {
	
	private String model;
	private String serialNumber;
	private Date manufacturedDate;
	private String category;

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Robot [model=" + model + ", serialNumber=" + serialNumber + ", manufacturedDate=" + manufacturedDate
				+ ", category=" + category + "]";
	}
	
}
