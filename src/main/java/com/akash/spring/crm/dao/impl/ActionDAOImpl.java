package com.akash.spring.crm.dao.impl;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
@Repository
public class ActionDAOImpl implements ActionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void create(Action action) {
        this.hibernateTemplate.save(action);
    }

    public List<Action> getIncompleteActions(String userId) throws RecordNotFoundException {
        return (List<Action>) this.hibernateTemplate.find("find from Action where action.owner=? and action.complete=false", userId);
    }

    public void update(Action action) throws RecordNotFoundException {
        this.hibernateTemplate.merge(action);
    }

    public void delete(Action action) throws RecordNotFoundException {
        Action action1 = this.hibernateTemplate.merge(action);
        this.hibernateTemplate.delete(action1);
    }
}

