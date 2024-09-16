package com.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passengerID;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false, unique = true)
    private String passportNumber;

    private String nationality;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
	public int getPassengerID() {
		return passengerID;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Passenger( String passengerName, String passportNumber, String nationality, String email,
			String password) {
		super();
		this.passengerName = passengerName;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
		this.email = email;
		this.password = password;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Passenger [passengerID=" + passengerID + ", passengerName=" + passengerName + ", passportNumber=" + passportNumber + ", nationality="
				+ nationality + ", email=" + email+ ", password=" + password + "]";
	}
}
