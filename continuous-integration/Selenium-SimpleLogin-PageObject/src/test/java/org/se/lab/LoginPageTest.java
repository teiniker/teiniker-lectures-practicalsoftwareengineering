package org.se.lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.se.lab.pages.LoginPage;
import org.se.lab.pages.WelcomePage;

public class LoginPageTest
{
    private LoginPage page;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        driver = new FirefoxDriver();
        page = new LoginPage(driver, "http://localhost:8080", 30);
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }

    
    @Test
    public void testLoginSuccess() throws Exception
    {
        // setup
        page.setUsername("student");
        page.setPassword("student");
        page.setUsergroup(LoginPage.Group.USER);

        // exercise
        WelcomePage welcome = page.login();
        String message = welcome.getMessage();
        
        // verify
        Assert.assertEquals("Welcome, student!", message);
    }
    
    
    @Test
    public void testLoginTestFailure() throws Exception
    {
        // setup + exercise
    	WelcomePage welcome = page.login("student", "password", LoginPage.Group.USER);
    	String message = welcome.getMessage();
        
        // verify
        Assert.assertEquals("Sorry, either your username or password is wrong...", message);
    }

}
