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
public class PersonDAOTest
{
	
	@Deployment
	public static JavaArchive createDeployment()
	{
		
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(Person.class, PersonDAO.class, PersonDAOInMemoryImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
				
		System.out.println(jar.toString(true));
		return jar;
	}

	@Inject
	private PersonDAO dao;
	
	@Test
	public void test()
	{
		Assert.assertNotNull(dao);
		
		dao.insert(new Person(7, "Homer", "Simpson"));
		
		Person p = dao.findById(7);
		
		System.out.println(p);
	}

}
