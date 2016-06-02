package com.akash.spring.crm.services.calls.impl;

import com.akash.spring.crm.dao.CallDAO;
import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.action.ActionService;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
@Transactional
@Service(value = "callService")
public class CallServiceImpl implements CallService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private CallDAO callDAO;

    public void recordCall(String customerID, Call call, Collection<Action> actions) throws CustomerNotFoundException {
        customerService.recordCall(customerID, call);
        for (Action action : actions) {
            actionService.recordAction(action);
        }
    }

    /**
     * Creates a new Call
     *
     * @param call
     */
    @Override
    public void create(Call call) {
        this.callDAO.create(call);
    }

    /**
     * Remove a Call
     *
     * @param call
     */
    @Override
    public void remove(Call call) {
        this.callDAO.remove(call);
    }

    /**
     * Update a Call
     *
     * @param call
     */
    @Override
    public void update(Call call) {
        this.update(call);
    }
}
