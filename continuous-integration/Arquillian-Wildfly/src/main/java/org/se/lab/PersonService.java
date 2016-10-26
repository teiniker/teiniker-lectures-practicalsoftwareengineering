package org.se.lab;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

@Stateless
public class PersonService
{
	private final Logger LOG = Logger.getLogger(PersonService.class);
	
	
	@Inject
	private PersonDAO dao;
	
	public void savePerson(long id, String firstName, String lastName)
	{
		LOG.debug("save Person: " + id + "," + firstName + "," + lastName);
		
		validateId(id);
		validateNameString(firstName, "firstname");
		validateNameString(lastName, "lastname");
				
		try
		{
			Person p = new Person(id, firstName, lastName);
			dao.insert(p);
		}
		//...
		catch(Throwable e)
		{
			LOG.error("Can't execute PersonService.savePerson()", e);
			throw new ServiceException("Can't save Person!", e);
		}
	}
	
	
	/*
	 * Helper methods
	 */
	
	private void validateId(long id)
	{
		if(id < 0)
			throw new IllegalArgumentException("Invalid parameter id!");
	}
	
	private final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z0-9-]{2,64}$");

	private void validateNameString(String name, String parameter)
	{
		if(name == null)
			throw new IllegalArgumentException("Parameter " + parameter + " is null!");
			
		String s = Normalizer.normalize(name, Form.NFKC);
		Matcher m = NAME_PATTERN.matcher(s);
		if(!m.matches())
			throw new IllegalArgumentException("Invalid parameter " + parameter + ": " + name);
		
	}
}
