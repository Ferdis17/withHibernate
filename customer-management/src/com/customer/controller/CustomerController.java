package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.dao.CustomerDao;
import com.customer.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer>customers = customerDao.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}

}
