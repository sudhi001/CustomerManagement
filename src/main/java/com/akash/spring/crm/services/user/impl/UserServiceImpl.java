/**
 * 
 */
package com.akash.spring.crm.services.user.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.spring.crm.dao.UserDAO;
import com.akash.spring.crm.model.User;
import com.akash.spring.crm.services.user.UserService;

/**
 * @author 1270524
 *
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.user.UserService#create(com.akash.spring.crm.model.User)
	 */
	@Override
	public void create(User user) {
		this.userDao.create(user);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.user.UserService#remove(com.akash.spring.crm.model.User)
	 */
	@Override
	public void remove(User user) {
		this.userDao.remove(user);
	}

	/* (non-Javadoc)
	 * @see com.akash.spring.crm.services.user.UserService#update(com.akash.spring.crm.model.User)
	 */
	@Override
	public void update(User user) {
		this.userDao.update(user);
	}
}
