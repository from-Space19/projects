package com.airport.service;

import java.util.List;

import com.airport.entity.Airline;

public interface AirlineService {
	public void registerAirline(Airline airline);
	public Airline getAirline(int airlineID);
	public List<Airline> getAllAirline();
	public void deleteAirline(int airlineID);
}
