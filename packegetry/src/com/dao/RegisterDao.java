package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.User;
import com.security.Validatepassword;

public class RegisterDao {

	  private static final SessionFactory factory = new Configuration()
	            .configure()
	            .addAnnotatedClass(User.class)
	            .buildSessionFactory();

	    public boolean doregister(User user) {
	        Session session = factory.openSession();
	        session.beginTransaction();
	        session.persist(user);
	        session.getTransaction().commit();
	        session.close();
	        return true;
	    }

	    public User getUserByEmailAndPassword(String email, String rawPassword) {
	        Session session = factory.openSession();

	        User user = session.createQuery("FROM User WHERE email = :email", User.class)
	                           .setParameter("email", email)
	                           .uniqueResult();
	        session.close();

	        if (user != null && Validatepassword.matchPassword(rawPassword, user.getPassword())) {
	            return user;
	        }

	        return null; 
	    }
	}