package com.airport.Doa;

import java.time.LocalDateTime;
import java.util.List;

import com.airport.entity.Booking;

public interface BookingDoa {
	public void bookTicket(Booking booking);
	public Booking getBookingDetails(int bookingID);
	public void updateBookingDetails(int bookingID, Booking updatedBooking);
	public List<Booking> getAllBookingByDate(LocalDateTime date);
	public List<Booking> getBookingsByFlight(int flightID);
	public void deleteBooking(int bookingID);
}
