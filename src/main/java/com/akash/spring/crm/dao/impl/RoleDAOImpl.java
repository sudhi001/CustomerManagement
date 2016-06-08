/**
 * 
 */
package com.akash.spring.crm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akash.spring.crm.dao.RoleDAO;
import com.akash.spring.crm.model.Role;

/**
 * @author 1270524
 *
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.RoleDAO#create(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void create(Role role) {
		this.entityManager.persist(role);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.RoleDAO#remove(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void remove(Role role) {
		role = this.entityManager.merge(role);
		this.entityManager.remove(role);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.dao.RoleDAO#update(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void update(Role role) {
		this.entityManager.merge(role);
	}

}
