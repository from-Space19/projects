package com.airport.DoaImpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.FlightDoa;
import com.airport.entity.Flight;
import com.airport.util.HibernateUtil;

public class FlightDoaImpl implements FlightDoa{

	@Override
	public void registerFlight(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
	}

	@Override
	public Flight getFlightDetails(int flightID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Flight.class, flightID );
        }
	}

	@Override
	public List<Flight> getAllFlights() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Flight",Flight.class).list();
		}
	}


	@Override
	public List<Flight> getAllFlightsByAirline(int airlineID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "FROM Flight WHERE airline.id = :airlineID";
			return session.createQuery(hql,Flight.class)
					.setParameter("airlineID", airlineID)
					.list();
		}
	}

	@Override
	public List<Flight> getFlightsByDate(LocalDate date) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Flights WHERE departureDate = :departureDate";
			return session.createQuery(hql,Flight.class)
					.setParameter("departureDate", date)
					.list();
		}
	}

	@Override
	public void updateFlightDetails(int flightID,Flight updatedFlight) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Flight existingFlight = session.get(Flight.class, flightID);
            if (existingFlight != null) {
                existingFlight.setAirline(updatedFlight.getAirline());
                existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
                existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
                existingFlight.setDepartureDate(updatedFlight.getDepartureDate());
                existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
                existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
                session.merge(existingFlight);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
	}

	@Override
	public void deleteFlightDetails(int flightID) {
	       Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Flight flight = session.get(Flight.class, flightID);
	            if (flight != null) {
	                session.remove(flight); 
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
