package com.akash.spring.crm.webservices.rest.controllers;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.webservices.rest.error.ErrorInformation;
import com.akash.spring.crm.webservices.rest.model.CustomerCollectionForRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ErrorInformation errorInformation;

	/**
	 * Exception Handler CustomerNotFoundException 
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorInformation> handlerForCustomerNotFoundException(Exception e, HttpServletRequest req) {
		errorInformation.setMessage("Requested Customer does not exist");
		errorInformation.setUri(req.getRequestURI());
		errorInformation.setException(e.toString());
		return new ResponseEntity<>(errorInformation, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception Handler OptimisticLockException 
	 */
	@ExceptionHandler(OptimisticLockException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public void handlerForOptimisticLocationException() {}

	/**
	 * Find Customer by ID, uses HTTP GET method
	 * 
	 * @param id
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	// @ResponseBody Not required if using @RestController
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException{
		return customerService.getFullCustomerDetail(id);
	}
	
	/**
	 * Get All Customers, uses HTTP GET method
	 * @return
	 */
	@RequestMapping(value = "/customerlist", method = RequestMethod.GET)
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
	
	/**
	 * Create a new customer, uses HTTP POST method
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	/**
	 * Delete a customer, uses HTTP DELETE method
	 * 
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable String id) throws CustomerNotFoundException {
		Customer customer = customerService.findCustomerById(id);
		customerService.deleteCustomer(customer);
	}
	
	/**
	 * Update full customer details, uses HTTP PUT method
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
		customerService.updateCustomer(customer);
	}
	
	/**
	 * Partial Update customer details, uses HTTP PATCH method
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PATCH)
	public void partialUpdateCustomer(@RequestBody Customer customer,
									  @PathVariable String id) throws CustomerNotFoundException{
		Customer customerById = customerService.findCustomerById(id);
		
		if (customer.getId() == null) {
			customer.setId(customerById.getId());
		}
		
		if (customer.getCustomerNotes() == null) {
			customer.setCustomerNotes(customerById.getCustomerNotes());
		}
		customerService.updateCustomer(customer);
	}
}
