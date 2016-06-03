package com.akash.spring.crm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akash.spring.crm.dao.ActionDAO;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;

/**
 * Created by Akash Agarwal on 5/3/2016.
 */
@Repository
public class ActionDAOImpl implements ActionDAO {

	@PersistenceContext
    private EntityManager entityManager;

    public void create(Action action) {
        this.entityManager.persist(action);
    }

    @SuppressWarnings("unchecked")
	public List<Action> getIncompleteActions(String owner) throws RecordNotFoundException {
    	return (List<Action>) this.entityManager.createQuery("select action from Action as action where action.owner=:owner")
    					  						.setParameter("owner", owner)
    					  						.getResultList();
    }

    public void update(Action action) throws RecordNotFoundException {
        this.entityManager.merge(action);
    }

    public void delete(Action action) throws RecordNotFoundException {
        action = this.entityManager.merge(action);
        this.entityManager.remove(action);
    }
}

