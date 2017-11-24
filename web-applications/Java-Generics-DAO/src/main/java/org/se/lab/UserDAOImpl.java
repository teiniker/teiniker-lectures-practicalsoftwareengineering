package org.se.lab;

import javax.persistence.EntityManager;

class UserDAOImpl
	extends DAOImplTemplate<User>
	implements UserDAO
{
	/*
	 * Constructor
	 */
	public UserDAOImpl(EntityManager em)
	{
		super(em);
	}
	
	@Override 
	protected Class<User> getEntityClass()
	{
		return User.class;
	}
	
	
	/*
	 * Factory methods
	 */

	@Override
	public User createUser(String username, String password)
	{
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		insert(u);
		return u;
	}
}
