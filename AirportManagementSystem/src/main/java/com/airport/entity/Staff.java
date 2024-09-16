package com.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffID;
	
    @Column(nullable = false)
    private String staffName;

    @Column(name = "role", nullable = false)
    private String staffRole;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private Airport airport;
    
	public int getStaffID() {
		return staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
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
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public Staff( String staffName, String staffRole, String email, String password, Airport airport) {
		super();
		this.staffName = staffName;
		this.staffRole = staffRole;
		this.email = email;
		this.password = password;
		this.airport = airport;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Staff [staffID=" + staffID + ", staffName=" + staffName + ", staffRole=" + staffRole + ", airport="
				+ airport.getAirportID() + ", email=" + email+ ", password=" + password + "]";
	}
}
