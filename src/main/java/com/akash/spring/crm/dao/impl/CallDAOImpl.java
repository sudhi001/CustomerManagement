package com.akash.spring.crm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akash.spring.crm.dao.CallDAO;
import com.akash.spring.crm.model.Call;

/**
 * Created by Akash Agarwal on 6/2/2016.
 */
@Repository
public class CallDAOImpl implements CallDAO {

	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Creates a new Call
     *
     * @param call
     */
    @Override
    public void create(Call call) {
        this.entityManager.persist(call);
    }

    /**
     * Remove a Call
     *
     * @param call
     */
    @Override
    public void remove(Call call) {
        call = this.entityManager.merge(call);
        this.entityManager.remove(call);
    }

    /**
     * Update a Call
     *
     * @param call
     */
    @Override
    public void update(Call call) {
        this.entityManager.merge(call);
    }
}
