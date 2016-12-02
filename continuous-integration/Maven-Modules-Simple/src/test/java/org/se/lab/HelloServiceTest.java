package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class HelloServiceTest
{
    @Test
    public void testSayHelloTo()
    {
        // setup
        HelloService service = new HelloService();
        
        // exercise
        int len = service.sayHelloTo("homer");
        
        // verify
        Assert.assertEquals(13, len);
        
        // tear down
    }
}
