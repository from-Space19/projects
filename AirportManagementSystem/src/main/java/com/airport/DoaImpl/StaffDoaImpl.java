package com.airport.DoaImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.airport.Doa.StaffDoa;
import com.airport.entity.Staff;
import com.airport.util.HibernateUtil;

public class StaffDoaImpl implements StaffDoa {

	@Override
	public void registerStaff(Staff staff) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(staff);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}			
	}

	@Override
	public Staff getStaffDetails(int staffID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Staff.class, staffID);
		}
	}

	@Override
	public List<Staff> getAllStaffsByRole(String role) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "FROM Staff WHERE role = :role";
            return session.createQuery(hql, Staff.class)
                          .setParameter("role", role)
                          .list();
		}
	}

	@Override
	public List<Staff> getAllStaffsByAirport(int airportID) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String hql = "FROM Staff WHERE airport.id = :airportID";
            return session.createQuery(hql, Staff.class)
                          .setParameter("airportID", airportID)
                          .list();
		}
	}

	@Override
	public void updateStaffDetails(int staffID, Staff updatedStaff) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Staff existingStaff = session.get(Staff.class, staffID);

			if (existingStaff != null) {
                existingStaff.setStaffName(updatedStaff.getStaffName());
                existingStaff.setPassword(updatedStaff.getPassword());
                existingStaff.setStaffRole(updatedStaff.getStaffRole());
                existingStaff.setEmail(updatedStaff.getEmail());
                existingStaff.setAirport(updatedStaff.getAirport());
			}
			session.merge(existingStaff);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}			
	}

	@Override
	public void deleteStaff(int staffID) {
	       Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Staff staff = session.get(Staff.class,staffID );
	            if (staff != null) {
	                session.remove(staff); 
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
