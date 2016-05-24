package com.akash.spring.crm.webservices;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/24/2016.
 */
@WebService(serviceName = "customerEndpointService")
public class CustomerEndpoint implements CustomerService {

    private CustomerService customerService;

    @WebMethod(exclude = true)
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Takes a customer domain object and saves it in the database
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        this.customerService.addCustomer(customer);
    }

    /**
     * The specified customer is updated in the database.
     *
     * @param customer
     */
    public void updateCustomer(Customer customer) throws CustomerNotFoundException {
        this.customerService.updateCustomer(customer);
    }

    /**
     * The specified customer is removed from the database
     *
     * @param customer
     */
    public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
        this.customerService.deleteCustomer(customer);
    }

    /**
     * Finds the customer by Id
     *
     * @param customerId
     */
    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        Customer customer = this.customerService.findCustomerById(customerId);
        if (customer != null) {
            customer.setCalls(null);
        }
        return customer;
    }

    /**
     * Finds customers by their name. Note that in a full system, we'd
     * probably offer more sophisticated searching functionality, but for the
     * practical this will do for now.
     *
     * @param name
     */
    public List<Customer> findCustomerByCompanyName(String name) throws CustomerNotFoundException {
        List<Customer> customerList = this.customerService.findCustomerByCompanyName(name);
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList) {
                customer.setCalls(null);
            }
        }
        return customerList;
    }

    /**
     * Returns a complete list of the customers in the system.
     */
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        List<Customer> customerList = this.customerService.getAllCustomers();
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList) {
                customer.setCalls(null);
            }
        }
        return customerList;
    }

    /**
     * For the specified customer, returns the customer object together
     * will all calls associated with that customer
     *
     * @param customerId
     * @throws CustomerNotFoundException
     */
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        return this.customerService.getFullCustomerDetail(customerId);
    }

    /**
     * Records a call against a particular customer
     *
     * @param customerId
     * @param callDetails
     */
    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        this.customerService.recordCall(customerId, callDetails);
    }
}
