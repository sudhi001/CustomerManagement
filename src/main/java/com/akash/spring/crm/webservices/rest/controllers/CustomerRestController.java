package com.akash.spring.crm.webservices.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/{id}")
	// @ResponseBody Not required if using @RestController
	public Customer findCustomerById(@PathVariable String id) {
		Customer customer = null;
		try {
			customer = customerService.getFullCustomerDetail(id);
		} catch (CustomerNotFoundException e) {
			throw new RuntimeException(e);
		}
		return customer;
	}
}
