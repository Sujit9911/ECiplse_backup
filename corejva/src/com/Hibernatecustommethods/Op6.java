package com.Hibernatecustommethods;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.util.List; 

public class Op6 {

	public static void main(String[] args) {
		

	Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Empm.class);
	
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(Empm.class);
		criteria.add(Restrictions.ge("salary",25000));
		List<Empm>list=criteria.list();
		for(Empm e:list) {
			System.out.println(e);
		}
	}}