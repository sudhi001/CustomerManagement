package com.akash.spring.crm.webservices.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.webservices.soap.xml.calls.CallXML;
import com.akash.spring.crm.webservices.soap.xml.customers.AddCustomerRequest;
import com.akash.spring.crm.webservices.soap.xml.customers.CustomerXML;
import com.akash.spring.crm.webservices.soap.xml.customers.DeleteCustomerRequest;
import com.akash.spring.crm.webservices.soap.xml.customers.GetCustomerByCompanyNameRequest;
import com.akash.spring.crm.webservices.soap.xml.customers.GetCustomerByCompanyNameResponse;
import com.akash.spring.crm.webservices.soap.xml.customers.GetCustomerByIdRequest;
import com.akash.spring.crm.webservices.soap.xml.customers.GetCustomerByIdResponse;
import com.akash.spring.crm.webservices.soap.xml.customers.GetFullCustomerDetailsRequest;
import com.akash.spring.crm.webservices.soap.xml.customers.GetFullCustomerDetailsResponse;
import com.akash.spring.crm.webservices.soap.xml.customers.UpdateCustomerRequest;

/**
 * Created by Akash Agarwal on 5/24/2016.
 */
@Endpoint
public class CustomerEndpoint {

    public static final String NAMESPACE = "http://www.akash.com/crm/customers";

    @Autowired
    private CustomerService customerService;

    /**
     * Handles SOAP Request for Adding new Customer.
     * 
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "addCustomerRequest")
    public void addCustomer(@RequestPayload AddCustomerRequest request) {
    	CustomerXML customerXML = request.getCustomer();
    	Customer customer = new Customer();
      	customer.setCompany(customerXML.getCompany());
    	customer.setCid(customerXML.getId());
    	customer.setCustomerNotes(customerXML.getCustomerNotes());
    	customer.setEmail(customerXML.getEmail());
    	customer.setTelephone(customerXML.getTelephone());
    	customerService.addCustomer(customer);
    }
    
    /**
     * Handles SOAP Request for Deleting existing Customer.
     * 
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteCustomerRequest")
    public void deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
    	CustomerXML customerXML = request.getCustomer();
    	Customer customer = new Customer();
    	customer.setCompany(customerXML.getCompany());
    	customer.setCid(customerXML.getId());
    	customer.setCustomerNotes(customerXML.getCustomerNotes());
    	customer.setEmail(customerXML.getEmail());
    	customer.setTelephone(customerXML.getTelephone());
    	List<Call> callList = new ArrayList<>();
    	for (CallXML callXML : customerXML.getCalls()) {
    		Call call = new Call();
    		call.setCallNotes(callXML.getCallNotes());
    		call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    		call.setId(callXML.getId());
    		callList.add(call);
    		call = null;
    	}
    	customer.setCalls(callList);
    	try {
			customerService.deleteCustomer(customer);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Handles SOAP Request for Updating existing Customer.
     * 
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "updateCustomerRequest")
    public void updateCustomer(@RequestPayload UpdateCustomerRequest request) {
    	CustomerXML customerXML = request.getCustomer();
    	Customer customer = new Customer();
    	customer.setCompany(customerXML.getCompany());
    	customer.setCid(customerXML.getId());
    	customer.setCustomerNotes(customerXML.getCustomerNotes());
    	customer.setEmail(customerXML.getEmail());
    	customer.setTelephone(customerXML.getTelephone());
     	List<Call> callList = new ArrayList<>();
    	for (CallXML callXML : customerXML.getCalls()) {
    		Call call = new Call();
    		call.setCallNotes(callXML.getCallNotes());
    		call.setCallTime(callXML.getCallTime().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
    		call.setId(callXML.getId());
    		callList.add(call);
    		call = null;
    	}
    	customer.setCalls(callList);
    	try {
			customerService.updateCustomer(customer);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Handles SOAP Request for Fetching Customer Details VIA customer ID.
     * 
     * @param request
     * @return
     * @throws CustomerNotFoundException
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "getCustomerByIdRequest")
    @ResponsePayload
    public GetCustomerByIdResponse fetchCustomerDetailsViaID(@RequestPayload GetCustomerByIdRequest request) throws CustomerNotFoundException {
    	String id = request.getId();
    	Customer customer = customerService.findCustomerById(id);
    	GetCustomerByIdResponse response = new GetCustomerByIdResponse(customer);
    	return response;
    }
    
    /**
     * Handles SOAP Request for Fetching Customer Details VIA customer Company Name.
     * 
     * @param request
     * @return
     * @throws CustomerNotFoundException
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "getCustomerByCompanyNameRequest")
    @ResponsePayload
    public GetCustomerByCompanyNameResponse fetchCustomerDetailsViaCompanyName(@RequestPayload GetCustomerByCompanyNameRequest request) throws CustomerNotFoundException {
    	String companyName = request.getCompanyName();
    	List<Customer> customerList = customerService.findCustomerByCompanyName(companyName);
    	GetCustomerByCompanyNameResponse response = new GetCustomerByCompanyNameResponse();
    	
    	for (Customer customer: customerList) {
    		CustomerXML customerXML = new CustomerXML();
    		customerXML.setCompany(customer.getCompany());
    		customerXML.setCustomerNotes(customer.getCustomerNotes());
    		customerXML.setId(customer.getCid());
    		customerXML.setEmail(customer.getEmail());
    		customerXML.setTelephone(customer.getTelephone());
    		response.getCustomer().add(customerXML);
    		customerXML = null;
    	}
		return response;
    }
    
    /**
     * Handles SOAP Request for Fetching Full Customer Details VIA customer ID.
     * 
     * @param request
     * @return
     * @throws CustomerNotFoundException
     */
    @PayloadRoot(namespace = NAMESPACE, localPart = "getFullCustomerDetailsRequest")
    @ResponsePayload
    public GetFullCustomerDetailsResponse fetchFullCustomerDetailsViaID(@RequestPayload GetFullCustomerDetailsRequest request) throws CustomerNotFoundException {
    	String id = request.getId();
    	Customer customer = customerService.getFullCustomerDetail(id);
    	GetFullCustomerDetailsResponse response = new GetFullCustomerDetailsResponse(customer);
    	return response;
    }
}