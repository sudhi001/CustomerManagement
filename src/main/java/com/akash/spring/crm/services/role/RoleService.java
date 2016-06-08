package com.akash.spring.crm.services.role;

import com.akash.spring.crm.model.Role;

public interface RoleService {

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
