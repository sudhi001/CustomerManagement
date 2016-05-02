package com.akash.spring.crm.dao;

import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface ActionDAO {

    /**
     * Creates a new Action
     */
    void create(Action action);

    /**
     * Returns a list of all incomplete actions for the user
     */
    List<Action> getIncompleteActions(String userId);

    /**
     * Updates an action
     *
     */
    void update(Action action) throws RecordNotFoundException;

    /**
     * Deletes an action
     *
     */
    void delete(Action action) throws RecordNotFoundException;
}
