package com.airport.Doa;

import java.util.List;

import com.airport.entity.Airport;

public interface AirportDoa {
	public void registerAirport(Airport airport);
	public Airport getAirport(int airportID);
	public List<Airport> getAllAirport();
	public void updateAirportDetails(int airportID,Airport updatedObject);
	public void deleteAirport(int airportID);
}
