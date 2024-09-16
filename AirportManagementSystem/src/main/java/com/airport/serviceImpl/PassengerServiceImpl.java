package com.airport.serviceImpl;

import java.util.List;

import com.airport.entity.Passenger;
import com.airport.Doa.PassengerDoa;
import com.airport.DoaImpl.PassengerDoaImpl;
import com.airport.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {

	private PassengerDoa passengerDoa = new PassengerDoaImpl();
	
	@Override
	public void registerPassenger(Passenger passenger) {
		passengerDoa.registerPassenger(passenger);		
	}

	@Override
	public Passenger getPassengerDetails(int passengerID) {
		// TODO Auto-generated method stub
		return passengerDoa.getPassengerDetails(passengerID);
	}

	@Override
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		return passengerDoa.getAllPassengers();
	}

	@Override
	public List<Passenger> getAllPassengersByFlight(int flightID) {
		// TODO Auto-generated method stub
		return passengerDoa.getAllPassengersByFlight(flightID);
	}

	@Override
	public void updatePassengerDetails(int passengerID, Passenger updatedPassenger) {
		passengerDoa.updatePassengerDetails(passengerID, updatedPassenger);		
	}

	@Override
	public void removePassenger(int passengerID) {
		passengerDoa.removePassenger(passengerID);		
	}

}
