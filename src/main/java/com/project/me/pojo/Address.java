package com.project.me.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Repository;
@Repository
@Entity
@Table(name="address")
public class Address {
	
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="ADDRESS_ID", unique=true, nullable=false )
	private long AddressID;
	
	@Column(name="ADDRESS_STREET", nullable=false)
	private String streetName;
	@Column(name="ADDRESS_CITY",  nullable=false)
	private String cityName;
	@Column(name="ADDRESS_STATE",  nullable=false)
	private String StateName;
	@Column(name="ADDRESS_ZIPCODE",  nullable=false)
	private int zipCode;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getAddressID() {
		return AddressID;
	}
	public void setAddressID(long addressID) {
		AddressID = addressID;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}

