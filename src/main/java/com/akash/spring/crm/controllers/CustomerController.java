package com.akash.spring.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
@Controller
public class CustomerController {
	
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/app/customers")
    public ModelAndView displayCustomers() {
        List<Customer> customerList = null;
        try {
            customerList = customerService.getAllCustomers();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        return new ModelAndView("/allCustomers.jsp", "customers", customerList);
    }
}
