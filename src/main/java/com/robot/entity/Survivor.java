package com.robot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "survivor")
public class Survivor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "infected")
	private boolean infected;
	
	@OneToOne(mappedBy = "survivor", cascade = {CascadeType.ALL})
	@JoinColumn(name = "survivorid")
	SurvivorResource survivorresource;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public boolean isInfected() {
		return infected;
	}
	public void setInfected(boolean infected) {
		this.infected = infected;
	}
	
	public SurvivorResource getSurvivorresource() {
		return survivorresource;
	}
	public void setSurvivorresource(SurvivorResource survivorresource) {
		this.survivorresource = survivorresource;
	}
	
	@Override
	public String toString() {
		return "Survivor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", latitude="
				+ latitude + ", longitude=" + longitude + ", infected=" + infected +"]";
	}
}
