package com.akash.spring.crm.services.calls.impl;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.services.diary.ActionService;

import java.util.Collection;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class CallServiceImpl implements CallService {
    private CustomerService customerService;
    private ActionService actionService;

    public CallServiceImpl(CustomerService customerService, ActionService actionService) {
        this.customerService = customerService;
        this.actionService = actionService;
    }

    public void recordCall(String customerID, Call call, Collection<Action> actions) throws CustomerNotFoundException {
        customerService.recordCall(customerID, call);
        for (Action action : actions) {
            actionService.recordAction(action);
        }
    }
}
