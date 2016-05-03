package com.akash.spring.crm.services.customer.impl;

import com.akash.spring.crm.dao.CustomerDAO;
import com.akash.spring.crm.dao.impl.CustomerDAOImpl;
import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO dao = new CustomerDAOImpl();

    public CustomerServiceImpl() {
        Customer cus1 = new Customer();
        cus1.setCompany("X");
        cus1.setId("1");
        cus1.setEmail("d");
        cus1.setTelephone("333");
        cus1.setCustomerNotes("ss");
        List<Call> calls = new ArrayList<Call>();
        Call call1 = new Call();
        call1.setCallNotes("First Call");
        calls.add(call1);
        cus1.setCustomerCalls(calls);
        dao.create(cus1);
    }

    public void addCustomer(Customer customer) {
        dao.create(customer);
    }

    public void updateCustomer(Customer customer) {
        try {
            dao.update(customer);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Customer customer) {
        try {
            dao.delete(customer);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        try {
            return dao.getById(customerId);
        } catch (RecordNotFoundException e) {
           e.printStackTrace();
        }
        return null;
    }

    public List<Customer> findCustomersByName(String name) {
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        try {
            return dao.getFullCustomerDetail(customerId);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        try {
            dao.addCall(callDetails, customerId);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }
}
