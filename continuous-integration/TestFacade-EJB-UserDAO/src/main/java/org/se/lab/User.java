package org.se.lab;

import java.io.Serializable;

public class User 
	implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected User() {}
	
	public User(String name)
	{
		setName(name);
	}
	
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}


	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}