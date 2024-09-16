package com.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airline_seq")
	@SequenceGenerator(name = "airline_seq" , sequenceName = "airline_sequence", initialValue=100000,allocationSize = 1)
	private int airlineID;
	
	@Column(nullable = false)
	private String airlineName;
	
	public int getAirlineID() {
		return airlineID;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public Airline( String airlineName) {
		super();
		this.airlineName = airlineName;
	}
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Airline [airlineID=" + airlineID + ", airlineName=" + airlineName + "]";
	}
}
