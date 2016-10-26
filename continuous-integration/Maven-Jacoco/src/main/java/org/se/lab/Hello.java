package org.se.lab;

public class Hello
{

	public String sayHelloTo(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");
		
		return "Hello " + name + "!";
	}
}
