package com.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_seq")
	@SequenceGenerator(name = "airport_seq" , sequenceName = "airport_sequence", initialValue = 1000, allocationSize = 1)
	private int airportID;
	
	@Column(nullable = false)
	private String airportName;
	
	@Column(name="location", nullable=false)
	private String airportLocation;
	
	public int getAirportID() {
		return airportID;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport( String airportName, String airportLocation) {
		super();
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public String toString() {
		return "Airport [airportID=" + airportID + ", airportName=" + airportName + ", airportLocation=" + airportLocation  + "]";
	}
}
