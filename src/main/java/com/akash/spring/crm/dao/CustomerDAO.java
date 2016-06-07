package com.akash.spring.crm.dao;

import java.util.List;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface CustomerDAO {

    /**
     * Creates a new customer record.
     */
    void create(Customer customer);

    /**
     * Finds a customer based on their ID
     */
    Customer getById(String customerId) throws CustomerNotFoundException;

    /**
     * Finds all customers whose company name matches the specified name
     */
    List<Customer> getByCompanyName(String name) throws CustomerNotFoundException;

    /**
     * Updates the specified customer in the database.
     */
    void update(Customer customer) throws CustomerNotFoundException;

    /**
     * Deletes the specified customer from the database.
     */
    void delete(Customer customer) throws CustomerNotFoundException;

    /**
     * Returns a complete collection of customer objects. Note that it is NOT necessary
     * to for this method to also return the associated calls (ie getCalls() will return null).
     *
     * This is for efficiency reasons - we may not be interested in the calls for ALL customers
     * in ths system.
     * @return
     */
    List<Customer> findAll() throws CustomerNotFoundException;

    /**
     * Returns the full detail for this customer - ie the customer object and ALL
     * calls associated with this customer
     */
    Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException;
    
    /**
     * Links the specifed call to the customer in the database.
     */
    List<Call> addCall(Call newCall, String customerId) throws CustomerNotFoundException;
}
