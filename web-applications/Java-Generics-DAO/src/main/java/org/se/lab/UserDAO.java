package org.se.lab;


public interface UserDAO
	extends DAOTemplate<User>
{
	User createUser(String username, String password);
}
