package com.akash.spring.crm.services;


import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.model.Role;
import com.akash.spring.crm.model.User;
import com.akash.spring.crm.services.action.ActionService;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.services.role.RoleService;
import com.akash.spring.crm.services.user.UserService;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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

    @Autowired
    private ActionService actionService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @PostConstruct
    public void init() throws CustomerNotFoundException {
    	Role role = new Role();
    	role.setName("ROLE_CRM_USER");
    	roleService.create(role);
    	
    	User user = new User();
    	user.setName("aka");
    	user.setPassword("akash");
    	List<Role> roles = new ArrayList<>();
    	roles.add(role);
    	user.setEnabled(true);
    	user.setRoles(roles);
    	userService.create(user);
    	
        Customer customer = new Customer();
        customer.setCompany("customer");
        customer.setEmail("customer@gmail.com");
        customer.setCustomerNotes("Hellocustomer");
        customer.setTelephone("333333");
        customerService.addCustomer(customer);
        
        Customer customer2 = new Customer();
        customer2.setCompany("customer2");
        customer2.setEmail("customer2@gmail.com");
        customer2.setCustomerNotes("Hellocustomer2");
        customer2.setTelephone("44444444");
        customerService.addCustomer(customer2);
        
        Customer customer3 = new Customer();
        customer3.setCompany("customer3");
        customer3.setEmail("customer3@gmail.com");
        customer3.setCustomerNotes("Hellocustomer3");
        customer3.setTelephone("555555");
        customerService.addCustomer(customer3);
        
        Customer customer4 = new Customer();
        customer4.setCompany("customer4");
        customer4.setEmail("customer4@gmail.com");
        customer4.setCustomerNotes("Hellocustomer4");
        customer4.setTelephone("66666");
        customerService.addCustomer(customer4);

        Action action = new Action();
        action.setDetails("y so serious customer");
        action.setOwner("actor");
        action.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        actionService.recordAction(action);

        Action action2 = new Action();
        action2.setDetails("y so serious customer2");
        action2.setOwner("actor2");
        action2.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        actionService.recordAction(action2);

        Action action3 = new Action();
        action3.setDetails("y so serious customer3");
        action3.setOwner("acto3r");
        action3.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        actionService.recordAction(action3);

        Action action4 = new Action();
        action4.setDetails("y so serious customer4");
        action4.setOwner("actor4");
        action4.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        actionService.recordAction(action4);

        Call call = new Call();
        call.setCallNotes("saying customer");
        call.setCallTime(LocalDateTime.now());
        callService.create(call);

        Call call2 = new Call();
        call2.setCallNotes("saying customer2");
        call2.setCallTime(LocalDateTime.now());
        callService.create(call2);

        Call call3 = new Call();
        call3.setCallNotes("saying customer3");
        call3.setCallTime(LocalDateTime.now());
        callService.create(call3);

        Call call4 = new Call();
        call4.setCallNotes("saying customer4");
        call4.setCallTime(LocalDateTime.now());
        callService.create(call4);

        Customer customer5 = new Customer();
        customer5.setCompany("customer5");
        customer5.setEmail("customer5@gmail.com");
        customer5.setCustomerNotes("Hellocustomer5");
        customer5.setTelephone("333333");
        Call call5 = new Call();
        call5.setCallNotes("saying customer5");
        call5.setCallTime(LocalDateTime.now());

        customer5.addCall(call5);
        customerService.addCustomer(customer5);


        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:crm", "--user", "sa", "--password", ""});
    }
}
