package com.akash.spring.crm.dao;

import com.akash.spring.crm.model.User;

public interface UserDAO {

	/**
	 * Creates a new User
	 */
	void create(User user);

	/**
	 * Remove a User
	 */
	void remove(User user);

	/**
	 * Update a User
	 */
	void update(User user);
}
