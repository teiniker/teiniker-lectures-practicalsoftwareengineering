package org.se.lab;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

@ManagedBean // or @Named in the context of JEE 
@SessionScoped
public class UserBean
	implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private final Logger LOG = Logger.getLogger(UserBean.class);
	
	/*
	 * Constructor
	 */
	public UserBean()
	{
		LOG.debug("Create: " + UserBean.class.getSimpleName());
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		LOG.debug("getName():" + name);
		return name;
	}
	public void setName(String name)
	{
		LOG.debug("setName(" + name + ")");
		this.name = name;
	}
	
	
	/*
	 * Property: password:String
	 */
	private String password;
	public String getPassword()
	{
		LOG.debug("getPassword():" + password);
		return password;
	}
	public void setPassword(String password)
	{
		LOG.debug("setPassword(" + password + ")");
		this.password = password;
	}
}
