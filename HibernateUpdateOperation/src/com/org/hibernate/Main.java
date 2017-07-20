package com.org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.UserDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		//create new objects
		/*for(int i=0;i<5;i++)
		{
			UserDetails userDetails=new UserDetails();
			userDetails.setUserName("bhawna"+i);
			session.save(userDetails);
		}
		*/
		UserDetails user=(UserDetails)session.get(UserDetails.class, 4);
		System.out.println("user details="+user.getUserName());

		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();



	}

}
