package com.airport.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import com.airport.entity.Booking;
import com.airport.Doa.BookingDoa;
import com.airport.DoaImpl.BookingDoaImpl;
import com.airport.service.BookingService;

public class BookingServiceImpl implements BookingService {

	private BookingDoa bookingDoa = new BookingDoaImpl();
	
	@Override
	public void bookTicket(Booking booking) {
		bookingDoa.bookTicket(booking);		
	}

	@Override
	public Booking getBookingDetails(int bookingID) {
		return bookingDoa.getBookingDetails(bookingID);
	}

	@Override
	public void updateBookingDetails(int bookingID, Booking updatedBooking) {
		bookingDoa.updateBookingDetails(bookingID, updatedBooking);		
	}

	@Override
	public List<Booking> getAllBookingByDate(LocalDateTime date) {
		return bookingDoa.getAllBookingByDate(date);
	}

	@Override
	public List<Booking> getBookingsByFlight(int flightID) {
		return bookingDoa.getBookingsByFlight(flightID);
	}

	@Override
	public void deleteBooking(int bookingID) {
		bookingDoa.deleteBooking(bookingID);		
	}

}
