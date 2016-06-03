package com.akash.spring.crm.services.calls.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.spring.crm.dao.CallDAO;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.services.calls.CallService;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
@Transactional
@Service(value = "callService")
public class CallServiceImpl implements CallService {

    @Autowired
    private CallDAO callDAO;

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
