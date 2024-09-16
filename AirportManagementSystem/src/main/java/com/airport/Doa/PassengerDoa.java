package com.airport.Doa;

import java.util.List;

import com.airport.entity.Passenger;

public interface PassengerDoa {
	public void registerPassenger(Passenger passenger);
	public Passenger getPassengerDetails(int passengerID);
	public List<Passenger> getAllPassengers();
	public List<Passenger> getAllPassengersByFlight(int flightID);
	public void updatePassengerDetails(int passengerID,Passenger updatedPassenger);
	public void removePassenger(int passengerID);
}
