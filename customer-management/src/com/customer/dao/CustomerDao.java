package com.customer.dao;

import java.util.List;

import com.customer.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
    public Customer getCustomer(int id);

    public void deleteCustomer(int theId);
            
}
