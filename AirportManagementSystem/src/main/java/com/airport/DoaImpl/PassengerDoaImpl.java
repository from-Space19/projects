package com.airport.DoaImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.PassengerDoa;
import com.airport.entity.Passenger;
import com.airport.util.HibernateUtil;

public class PassengerDoaImpl implements PassengerDoa{

	@Override
	public void registerPassenger(Passenger passenger) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(passenger);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}		
	}

	@Override
	public Passenger getPassengerDetails(int passengerID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Passenger.class, passengerID);
		}
	}

	@Override
	public List<Passenger> getAllPassengers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("From Passenger",Passenger.class).list();
		}
	}

	@Override
	public List<Passenger> getAllPassengersByFlight(int flightID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "FROM Passenger WHERE flight.flightID = :flightID";
            return session.createQuery(hql, Passenger.class)
                          .setParameter("flightID", flightID)
                          .list();
		}
	}

	@Override
	public void updatePassengerDetails(int passengerID, Passenger updatedPassenger) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Passenger existingPassenger = session.get(Passenger.class, passengerID);

			if (existingPassenger != null) {
				existingPassenger.setPassengerName(updatedPassenger.getPassengerName());
				existingPassenger.setEmail(updatedPassenger.getEmail());
				existingPassenger.setNationality(updatedPassenger.getNationality());
				existingPassenger.setPassword(updatedPassenger.getPassword());
				existingPassenger.setPassportNumber(updatedPassenger.getPassportNumber());
			}
			session.merge(existingPassenger);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}		
	}

	@Override
	public void removePassenger(int passengerID) {
	       Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Passenger passenger = session.get(Passenger.class,passengerID );
	            if (passenger != null) {
	                session.remove(passenger); 
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
