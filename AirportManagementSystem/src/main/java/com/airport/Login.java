package com.airport;

import org.hibernate.query.Query;

import org.hibernate.Session;

import com.airport.entity.Passenger;
import com.airport.util.HibernateUtil;

public class Login {
    public void passengerLogin(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Passenger WHERE email = :email";
            Query<Passenger> query = session.createQuery(hql, Passenger.class);
            query.setParameter("email", email);
            
            Passenger passenger = query.uniqueResult();
            
            if (passenger != null && passenger.getEmail().equals(email) && passenger.getPassword().equals(password)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during login");
        }
    }
}
