package org.se.lab;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named  
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
	
	@PostConstruct
	public void init()
	{
		System.out.println("init()");
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
	
	
	/*
	 * Actions
	 */
	
	public String login()
	{
		if(getName().equals("teini"))
		{
			return "welcome";			
		}
		else
		{
			return "loginFailed";
		}
	}
}
