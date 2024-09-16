package com.airport.Doa;

import java.util.List;

import com.airport.entity.Airline;

public interface AirlineDoa {
	public void registerAirline(Airline airline);
	public Airline getAirline(int airlineID);
	public List<Airline> getAllAirline();
	public void deleteAirline(int airlineID);
}
