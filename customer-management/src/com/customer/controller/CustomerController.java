package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.dao.CustomerDao;
import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer>customers = customerService.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer theCustomer = new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
		
	}

}
