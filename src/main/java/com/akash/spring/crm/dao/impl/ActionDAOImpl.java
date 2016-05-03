package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
public class ActionDAOImpl implements ActionDAO {

    public void create(Action action) {
    }

    public List<Action> getIncompleteActions(String userId) {
        return null;
    }

    public void update(Action action) throws RecordNotFoundException {

    }

    public void delete(Action action) throws RecordNotFoundException {

    }
}
