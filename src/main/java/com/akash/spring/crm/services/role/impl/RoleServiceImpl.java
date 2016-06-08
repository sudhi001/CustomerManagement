/**
 * 
 */
package com.akash.spring.crm.services.role.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.spring.crm.dao.RoleDAO;
import com.akash.spring.crm.model.Role;
import com.akash.spring.crm.services.role.RoleService;

/**
 * @author 1270524
 *
 */
@Transactional
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDao;
	
	
	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.role.RoleService#create(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void create(Role role) {
		this.roleDao.create(role);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.role.RoleService#remove(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void remove(Role role) {
		this.roleDao.remove(role);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.role.RoleService#update(com.akash.spring.crm.model.Role)
	 */
	@Override
	public void update(Role role) {
		this.roleDao.update(role);
	}
}
