package com.akash.spring.crm.dao;

import com.akash.spring.crm.model.Role;

public interface RoleDAO {

	/**
	 * Creates a new Role
	 */
	void create(Role role);

	/**
	 * Remove a Role
	 */
	void remove(Role role);

	/**
	 * Update a Role
	 */
	void update(Role role);
}
