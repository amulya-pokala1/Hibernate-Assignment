package com.accolite.interfaces;

import java.util.List;

import com.accolite.hibernate.model.Customer;



public interface CustomerDAOInterface {
	public Customer getCustomerById(int id);
	public List<Customer> getAllEmployees();
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public default void removeCustomer(Customer customer) {
		System.out.println("dummy remove method");
	}
	public void deleteCustomer(Customer customer);
	
}
