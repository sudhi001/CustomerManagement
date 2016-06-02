package com.akash.spring.crm.dao;

import com.akash.spring.crm.model.Call;

/**
 * Created by Akash Agarwal on 6/2/2016.
 */
public interface CallDAO {

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
