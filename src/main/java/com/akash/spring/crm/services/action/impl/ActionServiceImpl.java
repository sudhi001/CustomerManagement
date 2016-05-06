package com.akash.spring.crm.services.action.impl;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.services.action.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
@Transactional
@Service(value = "actionService")
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDAO dao;

    public void recordAction(Action action) {
        try {
            this.dao.create(action);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public List<Action> getAllIncompleteActions(String requiredUser) throws RecordNotFoundException {
        try {
            return this.dao.getIncompleteActions(requiredUser);
        } catch (DataAccessException e) {
            throw new RecordNotFoundException();
        }
    }
}
