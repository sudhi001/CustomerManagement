package com.akash.spring.crm.services;

import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
@Transactional
@Service
public class InitDBService {

    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        customer.setCompany("ABC");
        customer.setEmail("aaa");
        customer.setCustomerNotes("Hello");
        customer.setTelephone("333333");
        customer.setId("298532");
        customerService.addCustomer(customer);
    }
}
