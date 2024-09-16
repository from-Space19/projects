package com.airport.DoaImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.AirportDoa;
import com.airport.entity.Airport;
import com.airport.util.HibernateUtil;

public class AirportDoaImpl implements AirportDoa {

	@Override
	public void registerAirport(Airport airport) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(airport);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
	}

	@Override
	public Airport getAirport(int airportID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Airport.class, airportID );
        }
	}

	@Override
	public List<Airport> getAllAirport() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Airport",Airport.class).list();
		}
	}

	@Override
	public void updateAirportDetails(int airportID, Airport updatedAirport) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Airport existingAirport = session.get(Airport.class, airportID);
			if(existingAirport != null) {
				existingAirport.setAirportName(updatedAirport.getAirportName());
				existingAirport.setAirportLocation(updatedAirport.getAirportLocation());
			}
			session.merge(existingAirport);
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAirport(int airportID) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Airport airport = session.get(Airport.class, airportID);
            if (airport != null) {
                session.remove(airport);
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
