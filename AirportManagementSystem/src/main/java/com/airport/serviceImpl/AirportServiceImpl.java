package com.airport.serviceImpl;

import java.util.List;

import com.airport.entity.Airport;
import com.airport.Doa.AirportDoa;
import com.airport.DoaImpl.AirportDoaImpl;
import com.airport.service.AirportService;

public class AirportServiceImpl implements AirportService {

	private AirportDoa airportDoa = new AirportDoaImpl();
	@Override
	public void registerAirport(Airport airport) {
		airportDoa.registerAirport(airport);
	}

	@Override
	public Airport getAirport(int airportID) {
		return airportDoa.getAirport(airportID);
	}

	@Override
	public List<Airport> getAllAirport() {
		return airportDoa.getAllAirport();
	}

	@Override
	public void updateAirportDetails(int airportID, Airport updatedObject) {
		airportDoa.updateAirportDetails(airportID, updatedObject);		
	}

	@Override
	public void deleteAirport(int airportID) {
		airportDoa.deleteAirport(airportID);		
	}

}
