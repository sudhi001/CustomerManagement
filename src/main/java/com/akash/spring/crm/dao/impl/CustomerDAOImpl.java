package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.CustomerDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public class CustomerDAOImpl implements CustomerDAO{
    Map<String, Customer> testCus = new HashMap<String, Customer>();

    public void create(Customer customer) {
        testCus.put(customer.getId(), customer);
    }

    public Customer getById(String customerId) throws RecordNotFoundException {
        return testCus.get(customerId);
    }

    public List<Customer> getByName(String name) {
        return null;
    }

    public void update(Customer customer) throws RecordNotFoundException {
        testCus.put(customer.getId(), customer);
    }

    public void delete(Customer customer) throws RecordNotFoundException {
        testCus.remove(customer.getId());
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer getFullCustomerDetail(String customerId) throws RecordNotFoundException {
        return testCus.get(customerId);
    }

    public void addCall(Call call, String customerId) throws RecordNotFoundException {
        Customer customer = testCus.get(customerId);
        customer.addCall(call);
        testCus.put(customer.getId(), customer);
    }
}
