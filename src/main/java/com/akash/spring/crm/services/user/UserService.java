package com.akash.spring.crm.services.user;

import com.akash.spring.crm.model.User;

/**
 * Service for call management.
 *
 * Created by Akash Agarwal on 5/2/2016.
 */
public interface UserService {
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
