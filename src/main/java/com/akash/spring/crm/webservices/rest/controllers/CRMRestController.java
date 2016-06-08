package com.akash.spring.crm.webservices.rest.controllers;

import java.net.URI;
import java.util.List;

import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.action.ActionService;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.webservices.rest.error.ErrorInformation;
import com.akash.spring.crm.webservices.rest.model.ActionCollectionForRest;
import com.akash.spring.crm.webservices.rest.model.CallCollectionForRest;
import com.akash.spring.crm.webservices.rest.model.CustomerCollectionForRest;

@RestController
public class CRMRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
	private ErrorInformation errorInformation;
	
	Logger log = Logger.getLogger(CRMRestController.class);

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
	public void handlerForOptimisticLocationException() {
	}

	/**
	 * Find Customer by ID, uses HTTP GET method
	 * 
	 * @param id
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.GET)
	// @ResponseBody Not required if using @RestController
	public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException {
		return customerService.getFullCustomerDetail(id);
	}

	/**
	 * Get All Customers, uses HTTP GET method
	 * 
	 * Supports spring HATEOS for dynamic urls
	 * 
	 * @return
	 * @throws CustomerNotFoundException 
	 */
	@RequestMapping(value = "/rest/customerlist", method = RequestMethod.GET)
	public CustomerCollectionForRest getAllCustomers(@RequestParam(required = false) Integer first,
			@RequestParam(required = false) Integer last) throws CustomerNotFoundException {
		List<Customer> customers = null;
		customers = customerService.getAllCustomers();
		for (Customer customer : customers) {
			customer.setCalls(null);
			// Spring HATEOAS stuff
			Link link = ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(CRMRestController.class).findCustomerById(customer.getCid()))
					.withSelfRel();
			customer.add(link);
		}

		if (first != null && last != null) {
			CustomerCollectionForRest page = new CustomerCollectionForRest();
			page.setCustomers(customers.subList(first - 1, last));
			// Spring HATEOAS stuff
			page.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CRMRestController.class)
					.getAllCustomers(last + 1, last + 10))
					.withRel("next"));
			return page;
		} else {
			CustomerCollectionForRest customerRest = new CustomerCollectionForRest();
			customerRest.setCustomers(customers);
			return customerRest;			
		}
	}

	/**
	 * Create a new customer, uses HTTP POST method.
	 * 
	 * Supports general HATEOAS for dynamic urls
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/rest/customers", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		// HATEOAS stuff
		URI uri = MvcUriComponentsBuilder
				.fromMethodName(CRMRestController.class, "findCustomerById", newCustomer.getCid()).build().toUri();
		headers.setLocation(uri);
		return new ResponseEntity<Customer>(newCustomer, headers, HttpStatus.CREATED);
	}

	/**
	 * Delete a customer, uses HTTP DELETE method
	 * 
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.DELETE)
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
	@RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		customerService.updateCustomer(customer);
	}

	/**
	 * Partial Update customer details, uses HTTP PATCH method
	 * 
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	@RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.PATCH)
	public void partialUpdateCustomer(@RequestBody Customer customer, @PathVariable String id)
			throws CustomerNotFoundException {
		Customer customerById = customerService.findCustomerById(id);

		if (customer.getCid() == null) {
			customer.setCid(customerById.getCid());
		}

		if (customer.getCustomerNotes() == null) {
			customer.setCustomerNotes(customerById.getCustomerNotes());
		}
		customerService.updateCustomer(customer);
	}
	
	@RequestMapping(value = "/rest/customer/{id}/calls", method = RequestMethod.POST)
	public void recordCallForCustomer(@RequestBody Call call, @PathVariable String id) throws CustomerNotFoundException {
		customerService.recordCall(id, call);
	}

	@RequestMapping(value = "/rest/customer/{id}/calls", method = RequestMethod.GET)
	public CallCollectionForRest getCallDetailsForCustomer(@PathVariable String id) throws CustomerNotFoundException {
		Customer customer = customerService.getFullCustomerDetail(id);
		List<Call> calls = customer.getCalls();
		CallCollectionForRest callCollection = new CallCollectionForRest();
		callCollection.setCallList(calls);
		return callCollection;
	}
	
	@RequestMapping(value = "/rest/user/{id}/actions", method = RequestMethod.GET)
	public ActionCollectionForRest getAllIncompleteActionsForUser(@PathVariable String id) throws RecordNotFoundException {
		List<Action> actions = actionService.getAllIncompleteActions(id);
		ActionCollectionForRest actionCollection = new ActionCollectionForRest();
		actionCollection.setActionList(actions);
		return actionCollection;
	}
}
