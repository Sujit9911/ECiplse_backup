package com.dao;

import com.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PatientDAO {
    
    private SessionFactory factory;
    
    public PatientDAO() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();
    }
    
    public void save(Patient patient) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(patient);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    
    public Patient findByEmail(String email) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Patient WHERE email = :email", Patient.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
    
    public Patient findByContact(String contact) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Patient WHERE contactNumber = :contact", Patient.class)
                    .setParameter("contact", contact)
                    .uniqueResult();
        }
    }
    
    public void update(Patient patient) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.update(patient);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}