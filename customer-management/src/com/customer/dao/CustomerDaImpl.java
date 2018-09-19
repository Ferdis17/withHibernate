package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.entity.Customer;

@Repository
public class CustomerDaImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = currentSession.createQuery("delete from Customer where id=:id");
        theQuery.setParameter("id", theId);
        theQuery.executeUpdate();
    }

}
