package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.User;



public class RegisterDao {
 public boolean doRegister(User user) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.merge(user);
		session.beginTransaction().commit();
		return true;
	 
 }
}
