package com.akash.spring.crm.services.customer.impl;

import com.akash.spring.crm.dao.CustomerDAO;
import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO dao;

    public void addCustomer(Customer customer) {
        dao.create(customer);
    }

    public void updateCustomer(Customer customer) throws CustomerNotFoundException {
        try {
            dao.update(customer);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
        try {
            dao.delete(customer);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        try {
            return dao.getById(customerId);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> findCustomerByCompanyName(String name) throws CustomerNotFoundException {
        try {
            return this.dao.getByCompanyName(name);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        try {
            return this.dao.findAll();
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    @Transactional(readOnly = true)
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        try {
            return dao.getFullCustomerDetail(customerId);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }

    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        try {
            dao.addCall(callDetails, customerId);
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        }
    }
}
