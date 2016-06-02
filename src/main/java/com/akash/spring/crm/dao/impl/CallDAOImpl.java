package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.CallDAO;
import com.akash.spring.crm.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Akash Agarwal on 6/2/2016.
 */
@Repository
public class CallDAOImpl implements CallDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * Creates a new Call
     *
     * @param call
     */
    @Override
    public void create(Call call) {
        this.hibernateTemplate.save(call);
    }

    /**
     * Remove a Call
     *
     * @param call
     */
    @Override
    public void remove(Call call) {
        call = this.hibernateTemplate.merge(call);
        this.hibernateTemplate.delete(call);
    }

    /**
     * Update a Call
     *
     * @param call
     */
    @Override
    public void update(Call call) {
        this.hibernateTemplate.merge(call);
    }
}
