package com.airport.service;

import java.util.List;

import com.airport.entity.Staff;

public interface StaffService {
	public void registerStaff(Staff staff);
	public Staff getStaffDetails(int staffID);
	public List<Staff> getAllStaffsByRole(String role);
	public List<Staff> getAllStaffsByAirport(int airportID);
	public void updateStaffDetails(int staffID, Staff updatedStaff);
	public void deleteStaff(int staffID);
}
