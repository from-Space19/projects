package com.airport.DoaImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.BookingDoa;
import com.airport.entity.Booking;
import com.airport.util.HibernateUtil;

public class BookingDoaImpl implements BookingDoa {

	@Override
	public void bookTicket(Booking booking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(booking);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public Booking getBookingDetails(int bookingID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Booking.class, bookingID);
		}
	}

	@Override
	public void updateBookingDetails(int bookingID, Booking updatedBooking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Booking existingBooking = session.get(Booking.class, bookingID);

			if (existingBooking != null) {
				existingBooking.setBookingAmount(updatedBooking.getBookingAmount());
				existingBooking.setBookingDate(updatedBooking.getBookingDate());
				existingBooking.setFlight(updatedBooking.getFlight());
				existingBooking.setPassenger(updatedBooking.getPassenger());
				existingBooking.setSeatNumber(updatedBooking.getSeatNumber());
			}
			session.merge(existingBooking);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Booking> getAllBookingByDate(LocalDateTime date) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Booking WHERE bookingDate = :bookingDate";
			return session.createQuery(hql,Booking.class)
					.setParameter("bookingDate", date)
					.list();
		}
	}

	@Override
	public List<Booking> getBookingsByFlight(int flightID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "FROM Booking WHERE flight.flightID = :flightID";
            return session.createQuery(hql, Booking.class)
                          .setParameter("flightID", flightID)
                          .list();
		}
	}

	@Override
	public void deleteBooking(int bookingID) {
	       Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Booking booking = session.get(Booking.class, bookingID);
	            if (booking != null) {
	                session.remove(booking); 
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }

	}

}
