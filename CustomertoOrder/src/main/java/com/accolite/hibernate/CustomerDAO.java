package com.accolite.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.accolite.hibernate.model.Order;

import com.accolite.hibernate.model.Customer;

public class CustomerDAO {

	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void persistCustomer(Customer customer) {
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		}
	}
	
	public void persistOrder(Order order){
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
		}		
	}
	@Test
	
	
	public Customer getCustomerByCustId(Long custId) {		
		Customer customer = null;
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			customer = session.find(Customer.class, custId);
			System.out.println("customer :: "+customer);
			Set<Order> orders = customer.getOrders();
			System.out.println("customer :: "+orders);
			session.getTransaction().commit();
		}
		return customer;
	}
	
}
