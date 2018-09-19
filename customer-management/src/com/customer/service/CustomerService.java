package com.customer.service;

import java.util.List;

import com.customer.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);


    public Customer getCustomer(int id);

    public void deleteCustomer(int theId);

}
