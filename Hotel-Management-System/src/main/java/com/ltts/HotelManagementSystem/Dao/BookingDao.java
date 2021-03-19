package com.ltts.HotelManagementSystem.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.HotelManagementSystem.model.Booking;


@Repository
public class BookingDao {
	
	@Autowired
	private SessionFactory sf;
	
	
	
	
	
	public boolean InsertBooking(Booking m) 
	{
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(m);
			//System.out.println(st);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}
//		finally {
//			sf.close();
//	}
//		
		return b;
	}
	
	public List<Booking> getAllBooking(){
		Session session=sf.openSession();
        session.beginTransaction();
        
        List<Booking> li=sf.openSession().createCriteria(Booking.class).list();
        //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
        
        session.getTransaction().commit();
     
		return li;
		
	}
	
	
	
	
}
