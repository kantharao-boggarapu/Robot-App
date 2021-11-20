package com.robot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "survivorresource")
public class SurvivorResource {

	@Id
	@GeneratedValue
	@Column(name = "survivorid")
	private Long survivorid;
	
	@Column(name = "resources")
	private String resources;
	
	@OneToOne
    @PrimaryKeyJoinColumn(name = "survivorid", referencedColumnName = "id")
	Survivor survivor;

	public Long getSurvivorid() {
		return survivorid;
	}

	public void setSurvivorid(Long survivorid) {
		this.survivorid = survivorid;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	
	
}
