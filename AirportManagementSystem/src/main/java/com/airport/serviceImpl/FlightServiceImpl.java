package com.airport.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import com.airport.entity.Flight;
import com.airport.Doa.FlightDoa;
import com.airport.DoaImpl.FlightDoaImpl;
import com.airport.service.FlightService;

public class FlightServiceImpl implements FlightService{

	private FlightDoa flightDoa = new FlightDoaImpl();
	
	@Override
	public void registerFlight(Flight flight) {
		flightDoa.registerFlight(flight);		
	}

	@Override
	public Flight getFlightDetails(int flightID) {
		return flightDoa.getFlightDetails(flightID);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightDoa.getAllFlights();
	}

	@Override
	public List<Flight> getAllFlightsByAirline(int airlineID) {
		return flightDoa.getAllFlightsByAirline(airlineID);
	}

	@Override
	public List<Flight> getFlightsByDate(LocalDate date) {
		return flightDoa.getFlightsByDate(date);
	}

	@Override
	public void updateFlightDetails(int flightID, Flight updatedFlight) {
		flightDoa.updateFlightDetails(flightID, updatedFlight);		
	}

	@Override
	public void deleteFlightDetails(int flightID) {
		flightDoa.deleteFlightDetails(flightID);		
	}

}
