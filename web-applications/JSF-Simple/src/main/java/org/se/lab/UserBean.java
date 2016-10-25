package org.se.lab;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean // or @Named in the context of JEE 
@SessionScoped
public class UserBean
	implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructor
	 */
	public UserBean()
	{
		System.out.println("UserBean()");
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		System.out.println("getName():" + name);
		return name;
	}
	public void setName(String name)
	{
		System.out.println("setName(" + name + ")");
		this.name = name;
	}
	
	
	/*
	 * Property: password:String
	 */
	private String password;
	public String getPassword()
	{
		System.out.println("getPassword():" + password);
		return password;
	}
	public void setPassword(String password)
	{
		System.out.println("setPassword(" + password + ")");
		this.password = password;
	}
}
