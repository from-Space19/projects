package com.airport.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingID;
	
	@Column(name="booking_date", nullable = false)
	private LocalDateTime bookingDate;
	
	@Column(name = "amount", nullable = false)
	private float bookingAmount;
	
	@Column(nullable = false)
	private String seatNumber;
	
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;
	public int getBookingID() {
		return bookingID;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public float getBookingAmount() {
		return bookingAmount;
	}
	public void setBookingAmount(float bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Booking( LocalDateTime bookingDate, float bookingAmount, String seatNumber, Flight flight,
			Passenger passenger) {
		super();
		this.bookingDate = bookingDate;
		this.bookingAmount = bookingAmount;
		this.seatNumber = seatNumber;
		this.flight = flight;
		this.passenger = passenger;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", bookingAmount=" + bookingAmount + ", bookingDate=" + bookingDate + ", seatNumber="
				+ seatNumber + ", flightID=" + flight.getFlightID()+ ", passengerID=" + passenger.getPassengerID() + "]";
	}
}
