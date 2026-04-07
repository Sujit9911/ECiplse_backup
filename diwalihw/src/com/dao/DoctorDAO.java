package com.dao;

import com.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DoctorDAO {
    
    private SessionFactory factory;
    
    public DoctorDAO() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();
    }
    
    public void save(Doctor doctor) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(doctor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    
    public Doctor findByEmail(String email) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Doctor WHERE email = :email", Doctor.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}