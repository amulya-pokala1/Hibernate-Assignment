package com.accolite.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate.model.Customer;
import com.accolite.interfaces.CustomerDAOInterface;

public class CustomerDAOInterfaceImpl implements CustomerDAOInterface{

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
			try (Session session = sessFact.getCurrentSession();) {
				session.getTransaction().begin();
				session.save(customer);
				
				session.getTransaction().commit();
			}

		}
	

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
