package com.akash.spring.crm.services.calls.impl;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.services.diary.DiaryService;

import java.util.Collection;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class CallServiceImpl implements CallService {
    private CustomerService customerService;
    private DiaryService diaryService;

    public CallServiceImpl(CustomerService customerService, DiaryService diaryService) {
        this.customerService = customerService;
        this.diaryService = diaryService;
    }

    public void recordCall(String customerID, Call call, Collection<Action> actions) throws CustomerNotFoundException {
        customerService.recordCall(customerID, call);
        for (Action action : actions) {
            diaryService.recordAction(action);
        }
    }
}
