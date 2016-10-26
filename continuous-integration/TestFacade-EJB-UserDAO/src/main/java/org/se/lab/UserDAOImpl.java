package org.se.lab;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;


@Stateless
@Local(UserDAO.class)
public class UserDAOImpl 
	implements UserDAO
{
	private final Logger LOG = Logger.getLogger(UserDAOImpl.class.getSimpleName());
	
	
    /*
     * DOA operations
     */
    
	public void insert(User user) 
	{
		LOG.info("insert(" + user + ")");
	}

    public void update(User user)
    {
		LOG.info("update(" + user + ")");
    }

    public void delete(long id)
    {
		LOG.info("delete(" + id + ")");
    }

    public User findById(long id)
    {
		LOG.info("findMyId(" + id + ")");
		
		return new User("homer");
    }
    
	public List<User> findAll()
	{
		LOG.info("findAll()");
		
		return Arrays.asList(new User("homer"), new User("marge"), new User("lisa"), new User("bart"), new User("maggie"));
	}
}
