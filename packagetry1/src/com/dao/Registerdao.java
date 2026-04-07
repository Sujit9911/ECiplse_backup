package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import com.entity.User;
import org.hibernate.criterion.Projections;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class Registerdao {
 public boolean doRegister(User user) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		 session.save(user); 
		 Criteria criteria = session.createCriteria(User.class);

		

		// Restrictions: profile = "test" AND salary > 25000
		criteria.add(Restrictions.eq("profile", "dec"));
		criteria.setProjection(Projections.avg("salary"));

		// Get results
		List<Double> names = criteria.list();

		// Print names
		names.forEach(System.out::println);
		session.getTransaction().commit();
return  true;}}