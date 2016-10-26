package org.se.lab;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


@Monitored
public class UserDAOImpl 
	implements UserDAO
{
	@Inject
    private EntityManager em;
	    
	
    /*
     * DOA operations
     */
    
	public void insert(User user) 
	{
		em.persist(user);
	}

    public void update(User p)
    {

    }

    public void delete(long id)
    {

    }

    public User findById(long id)
    {
        return em.find(User.class, id);      
    }
    
	@SuppressWarnings("unchecked")
	public List<User> findAll()
	{
		List<User> users = em.createQuery("SELECT u FROM User AS u").getResultList();
		return users;
	}
}
