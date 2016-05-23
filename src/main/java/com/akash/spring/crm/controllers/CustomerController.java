package com.akash.spring.crm.controllers;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
@Controller
public class CustomerController {

    static Logger log = Logger.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public ModelAndView displayCustomers() {
        List<Customer> customerList = null;
        try {
            customerList = customerService.getAllCustomers();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        log.debug("touched displauedd");
        return new ModelAndView("/allCustomers.jsp", "customers", customerList);
    }
}
