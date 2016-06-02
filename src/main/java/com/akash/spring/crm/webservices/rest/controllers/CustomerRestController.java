package com.akash.spring.crm.webservices.rest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.webservices.rest.error.ErrorInformation;
import com.akash.spring.crm.webservices.rest.model.CustomerCollectionForRest;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ErrorInformation errorInformation;
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorInformation> handlerForCustomerNotFoundException(Exception e, HttpServletRequest req) {
		errorInformation.setMessage("Requested Customer does not exist");
		errorInformation.setUri(req.getRequestURI());
		errorInformation.setException(e.toString());
		return new ResponseEntity<>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/customer/{id}")
	// @ResponseBody Not required if using @RestController
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException{
		return customerService.getFullCustomerDetail(id);
	}
	
	@RequestMapping(value = "/customerlist")
	public CustomerCollectionForRest getAllCustomers() {
		List<Customer> customers = null;
		try {
			customers = customerService.getAllCustomers();
			for (Customer customer : customers) {
				customer.setCalls(null);
			}
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		CustomerCollectionForRest customerRest = new CustomerCollectionForRest();
		customerRest.setCustomers(customers);
		return customerRest;
	}
}
