/**
 * 
 */
package com.akash.spring.crm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akash.spring.crm.dao.UserDAO;
import com.akash.spring.crm.model.User;

/**
 * @author 1270524
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.UserDAO#create(com.akash.spring.crm.model.User)
	 */
	@Override
	public void create(User user) {
		this.entityManager.persist(user);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.UserDAO#remove(com.akash.spring.crm.model.User)
	 */
	@Override
	public void remove(User user) {
		user = this.entityManager.merge(user);
		this.entityManager.remove(user);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.UserDAO#update(com.akash.spring.crm.model.User)
	 */
	@Override
	public void update(User user) {
		this.entityManager.merge(user);
	}

}
