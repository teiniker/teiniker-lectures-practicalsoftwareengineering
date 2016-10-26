package org.se.lab;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserDAO.class)
public class UserDAOTestFacade
	implements UserDAO
{
	@EJB(beanName="UserDAOImpl")
	private UserDAO dao;
	
	@Override
	public void insert(User user)
	{
		dao.insert(user);
	}

	@Override
	public void update(User user)
	{
		dao.update(user);
	}

	@Override
	public void delete(long id)
	{
		dao.delete(id);
	}

	@Override
	public User findById(long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<User> findAll()
	{
		return findAll();
	}
}
