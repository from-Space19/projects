package com.airport.DoaImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.AirlineDoa;
import com.airport.entity.Airline;
import com.airport.util.HibernateUtil;

public class AirlineDoaImpl implements AirlineDoa {

	@Override
	public void registerAirline(Airline airline) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ){
			transaction = session.beginTransaction();
			session.persist(airline);
			transaction.commit();
		}
		catch(Exception e) {
	        if (transaction != null && transaction.isActive()) {  // Only rollback if transaction is active
	            transaction.rollback();
	        }
			e.printStackTrace();
		}		
	}

	@Override
	public Airline getAirline(int airlineID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Airline.class, airlineID);
		}
	}

	@Override
	public List<Airline> getAllAirline() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Airline", Airline.class).list();
		}
	}

	@Override
	public void deleteAirline(int airlineID) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Airline airline = session.get(Airline.class, airlineID);
			if(airline != null) {
				session.remove(airline);
			}
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
}
