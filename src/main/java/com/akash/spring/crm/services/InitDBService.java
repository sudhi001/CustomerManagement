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
        customer.setCompany("customer");
        customer.setEmail("customer@gmail.com");
        customer.setCustomerNotes("Hellocustomer");
        customer.setTelephone("333333");
        customer.setId("19532");
        customerService.addCustomer(customer);
        
        Customer customer2 = new Customer();
        customer2.setCompany("customer2");
        customer2.setEmail("customer2@gmail.com");
        customer2.setCustomerNotes("Hellocustomer2");
        customer2.setTelephone("44444444");
        customer2.setId("19332");
        customerService.addCustomer(customer2);
        
        Customer customer3 = new Customer();
        customer3.setCompany("customer3");
        customer3.setEmail("customer3@gmail.com");
        customer3.setCustomerNotes("Hellocustomer3");
        customer3.setTelephone("555555");
        customer3.setId("19432");
        customerService.addCustomer(customer3);
        
        Customer customer4 = new Customer();
        customer4.setCompany("customer4");
        customer4.setEmail("customer4@gmail.com");
        customer4.setCustomerNotes("Hellocustomer4");
        customer4.setTelephone("66666");
        customer4.setId("19632");
        customerService.addCustomer(customer4);
        
        Call call = new Call();
        call.setCallNotes("saying customer");
        call.setCallTime(LocalDateTime.now());

        List<Action> actions = new ArrayList<Action>();
        Action action = new Action();
        action.setDetails("y so serious customer");
        action.setOwner("actor");
        action.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        actions.add(action);
        
        Call call2 = new Call();
        call2.setCallNotes("saying customer2");
        call2.setCallTime(LocalDateTime.now());
        
        Action action2 = new Action();
        action2.setDetails("y so serious customer2");
        action2.setOwner("actor2");
        action2.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        List<Action> actions2 = new ArrayList<Action>();
        actions2.add(action2);
        
        Call call3 = new Call();
        call3.setCallNotes("saying customer3");
        call3.setCallTime(LocalDateTime.now());
        
        Action action3 = new Action();
        action3.setDetails("y so serious customer3");
        action3.setOwner("acto3r");
        action3.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        List<Action> actions3 = new ArrayList<Action>();
        actions3.add(action3);
        
        Call call4 = new Call();
        call4.setCallNotes("saying customer4");
        call4.setCallTime(LocalDateTime.now());
        
        Action action4 = new Action();
        action4.setDetails("y so serious customer4");
        action4.setOwner("actor4");
        action4.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        List<Action> actions4 = new ArrayList<Action>();
        actions4.add(action4);
        
        
        try {
			callService.recordCall("19532", call, actions);
			callService.recordCall("19332", call2, actions2);
			callService.recordCall("19432", call3, actions3);
			callService.recordCall("19632", call4, actions4);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}

        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:crm", "--user", "sa", "--password", ""});
    }
}
