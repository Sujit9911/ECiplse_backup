package com.Hibernatecustommethods;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
public class Clientdata {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Empm.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Empm e1=new Empm();
		e1.setName("john");
		e1.setProfile("dev");
		e1.setEmail("john@gmail.com");
		e1.setSalary(51000);
		e1.setAge(39);
		e1.setExp(27);
		session.save(e1);
		
		session.beginTransaction().commit();
session.close();

		
		
		
		
		

	}

}
