package com.akash.spring.crm.rmi.client;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("file:src\\main\\resources\\spring\\rmi-client-config.xml");
        CustomerService cs = container.getBean(CustomerService.class);
        List<Customer> customerList = null;
        try {
            customerList = cs.getAllCustomers();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        for (Customer customer : customerList) {
            System.out.println(customer.getCompany());
        }

        container.close();
    }
}
