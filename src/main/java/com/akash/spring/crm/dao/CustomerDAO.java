package com.akash.spring.crm.dao;

import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;

import java.util.List;

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
    Customer getById(String customerId) throws RecordNotFoundException;

    /**
     * Finds all customers whose company name matches the specified name
     */
    List<Customer> getByName(String name);

    /**
     * Updates the specified customer in the database.
     */
    void update(Customer customer) throws RecordNotFoundException;

    /**
     * Deletes the specified customer from the database.
     */
    void delete(Customer customer) throws RecordNotFoundException;

    /**
     * Returns a complete collection of customer objects. Note that it is NOT necessary
     * to for this method to also return the associated calls (ie getCalls() will return null).
     *
     * This is for efficiency reasons - we may not be interested in the calls for ALL customers
     * in ths system.
     * @return
     */
    List<Customer> getAllCustomers();

    /**
     * Returns the full detail for this customer - ie the customer object and ALL
     * calls associated with this customer
     */
    Customer getFullCustomerDetail(String customerId) throws RecordNotFoundException;

    /**
     * Links the specifed call to the customer in the database.
     */
    void addCall (Call newCall, String customerId) throws RecordNotFoundException;
}
