package org.se.lab;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserManager
{
	private final Logger LOG = Logger.getLogger(UserManager.class.getName());
	
	// see META-INF/persistence.xml for persistance unit configuration
	@PersistenceContext
	private EntityManager em;


	public User insert(String name) 
	{
		LOG.info("insert(" + name + ")");
		
		User user = new User();
		user.setName(name);
		em.persist(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll()
	{
		LOG.info("findAll()");
		List<User> customers = em.createQuery("select u from User u").getResultList();
		return customers;
	}
}
