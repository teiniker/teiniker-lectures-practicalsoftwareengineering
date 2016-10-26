package org.se.lab;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PersonServiceTest
{
	
	@Deployment
	public static JavaArchive createDeployment()
	{
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(PersonService.class, Person.class, PersonDAO.class, PersonDAOInMemoryImpl.class, ServiceException.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
				
		System.out.println(jar.toString(true));
		return jar;
	}

	@Inject
	private PersonService service;
	
	
	@Test
	public void testSavePerson()
	{
		Assert.assertNotNull(service);
		
		service.savePerson(7, "Homer", "Simpson");
	}
	
	
	@Test
	public void testSavePerson_InvalidId()
	{
		try
		{
			service.savePerson(-1, "Homer", "Simpson");
			Assert.fail();
		}
		catch(javax.ejb.EJBException e)
		{
			Throwable t = e.getCause();
			Assert.assertTrue(t instanceof IllegalArgumentException);
			Assert.assertEquals("Invalid parameter id!", t.getMessage());
		}
	}
}
