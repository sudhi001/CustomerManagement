package com.akash.spring.crm.services.calls;

import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;

import java.util.Collection;

/**
 * Service for call management.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface CallService {

    /**
     * Records a call with the customer management service, and also records
     * any actions in the action service
     */
    void recordCall(String customerID, Call call, Collection<Action> actions)
            throws CustomerNotFoundException;

    /**
     * Creates a new Call
     */
    void create(Call call);

    /**
     * Remove a Call
     */
    void remove(Call call);

    /**
     * Update a Call
     */
    void update(Call call);
}
