package com.akash.spring.crm.services.calls;

import com.akash.spring.crm.model.Call;

/**
 * Service for call management.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface CallService {
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
