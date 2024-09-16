package com.airport.serviceImpl;

import java.util.List;

import com.airport.entity.Airline;
import com.airport.service.AirlineService;
import com.airport.Doa.AirlineDoa;
import com.airport.DoaImpl.AirlineDoaImpl;

public class AirlineServiceImpl implements AirlineService{

	private AirlineDoa airlineDoa = new AirlineDoaImpl();
	
	@Override
	public void registerAirline(Airline airline) {
		airlineDoa.registerAirline(airline);
		
	}

	@Override
	public Airline getAirline(int airlineID) {
        return airlineDoa.getAirline(airlineID);

	}

	@Override
	public List<Airline> getAllAirline() {
        return airlineDoa.getAllAirline();

	}

	@Override
	public void deleteAirline(int airlineID) {
		airlineDoa.deleteAirline(airlineID);
		
	}

}
