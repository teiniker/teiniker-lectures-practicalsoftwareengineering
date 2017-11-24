package org.se.lab;

import java.util.List;

public interface DAOTemplate<E>
{
	E insert(E user);
	E update(E user);
	void delete(E user);
	
	E findById(int id);
	List<E> findAll();
}
