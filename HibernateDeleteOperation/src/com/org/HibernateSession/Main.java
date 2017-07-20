package com.org.HibernateSession;

import com.org.HibernateSession.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user=(UserDetails)session.get(UserDetails.class, 3);
		System.out.println("user details="+user.getUserName());

		user.setUserName("username modified");
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
