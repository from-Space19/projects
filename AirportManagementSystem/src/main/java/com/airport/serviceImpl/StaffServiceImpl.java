package com.airport.serviceImpl;

import java.util.List;

import com.airport.entity.Staff;
import com.airport.Doa.StaffDoa;
import com.airport.DoaImpl.StaffDoaImpl;
import com.airport.service.StaffService;

public class StaffServiceImpl implements StaffService {

	private StaffDoa staffDoa = new StaffDoaImpl();
	
	@Override
	public void registerStaff(Staff staff) {
		staffDoa.registerStaff(staff);		
	}

	@Override
	public Staff getStaffDetails(int staffID) {
		return staffDoa.getStaffDetails(staffID);
	}

	@Override
	public List<Staff> getAllStaffsByRole(String role) {
		return staffDoa.getAllStaffsByRole(role);
	}

	@Override
	public List<Staff> getAllStaffsByAirport(int airportID) {
		return staffDoa.getAllStaffsByAirport(airportID);
	}

	@Override
	public void updateStaffDetails(int staffID, Staff updatedStaff) {
		staffDoa.updateStaffDetails(staffID, updatedStaff);		
	}

	@Override
	public void deleteStaff(int staffID) {
		staffDoa.deleteStaff(staffID);		
	}

}
