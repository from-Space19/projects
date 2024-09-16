package com.airport.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "flight_sequence", initialValue = 10000, allocationSize = 1)
    private int flightID;

    @Column(nullable = false)
    private LocalDate departureDate;

    private LocalTime departureTime;
    
    private LocalTime arrivalTime;

    @OneToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @OneToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;
    
	public int getFlightID() {
		return flightID;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Flight( LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime,
			Airport departureAirport, Airport arrivalAirport, Airline airline) {
		super();

		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.airline = airline;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", departureAirport=" + departureAirport.getAirportID()+ ", arrivalAirport=" + arrivalAirport.getAirportID() + ", airlineID=" + airline.getAirlineID() + "]";
	}
}
