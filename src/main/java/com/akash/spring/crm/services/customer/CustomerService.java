package com.akash.spring.crm.services.customer;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;

import java.util.List;

/**
 * This interface defines the functionality we want the Customer Management Service
 * to offer.
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface CustomerService {

    /**
     * Takes a customer domain object and saves it in the database
     */
    void addCustomer(Customer customer);

    /**
     * The specified customer is updated in the database.
     */
    void updateCustomer(Customer customer);

    /**
     * The specified customer is removed from the database
     */
    void deleteCustomer(Customer customer);

    /**
     * Finds the customer by Id
     */
    Customer findCustomerById(String customerId) throws CustomerNotFoundException;

    /**
     * Finds customers by their name. Note that in a full system, we'd
     * probably offer more sophisticated searching functionality, but for the
     * practical this will do for now.
     */
    List<Customer> findCustomersByName (String name);

    /**
     * Returns a complete list of the customers in the system.
     */
    List<Customer> getAllCustomers();

    /**
     * For the specified customer, returns the customer object together
     * will all calls associated with that customer
     * @throws CustomerNotFoundException
     */
    Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException;

    /**
     * Records a call against a particular customer
     *
     */
    void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException;
}
