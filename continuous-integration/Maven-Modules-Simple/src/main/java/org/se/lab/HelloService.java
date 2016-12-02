package org.se.lab;

public class HelloService
{
	public int sayHelloTo(String name)
	{
	    String msg = "Hello, " + name + "!"; 
	    System.out.println(msg);
		return msg.length();
	}
}
