package com.airport.service;

import java.time.LocalDate;
import java.util.List;

import com.airport.entity.Flight;

public interface FlightService {
	public void registerFlight(Flight flight);
	public Flight getFlightDetails(int flightID);
	public List<Flight> getAllFlights();
	public List<Flight> getAllFlightsByAirline(int airlineID);
	public List<Flight> getFlightsByDate(LocalDate date);
	public void updateFlightDetails(int flightID,Flight updatedFlight);
	public void deleteFlightDetails(int flightID);
	
}
