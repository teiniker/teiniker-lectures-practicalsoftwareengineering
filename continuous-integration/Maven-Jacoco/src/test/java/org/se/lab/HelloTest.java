package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloTest
{
	private Hello hello;
	
	@Before
	public void setup()
	{
		hello = new Hello();
	}
	
	@Test
	public void testSayHello()
	{
		String result = hello.sayHelloTo("KBerg");
		
		Assert.assertEquals("Hello KBerg!", result);
	}
	
}
