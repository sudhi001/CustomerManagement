package com.akash.spring.crm.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
@Transactional
@Service
public class InitDBService {

    @Autowired
    private CustomerService customerService;
    
    @Autowired 
    private CallService callService;
    
    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        customer.setCompany("ABC");
        customer.setEmail("aaa");
        customer.setCustomerNotes("Hello");
        customer.setTelephone("333333");
        customer.setId("19532");
        customerService.addCustomer(customer);
        
        Call call = new Call();
        call.setCallNotes("saying call");
        call.setCallTime(LocalDateTime.now());
        
        Action action = new Action();
        action.setDetails("y so serious");
        action.setOwner("mw");
        action.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        List<Action> actions = new ArrayList<Action>();
        actions.add(action);
        
        try {
			callService.recordCall("19532", call, actions);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:crm", "--user", "sa", "--password", ""});
    }
}
