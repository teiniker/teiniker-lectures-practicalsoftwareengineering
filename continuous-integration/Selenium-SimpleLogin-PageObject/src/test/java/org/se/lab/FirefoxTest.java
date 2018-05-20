package org.se.lab;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.se.lab.pages.LoginPage;
import org.se.lab.pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class FirefoxTest
{
    private LoginPage page;
    private WebDriver driver;

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.gecko.driver","/home/student/install/geckodriver/geckodriver");
    }

    @Before
    public void setUp() throws Exception
    {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", false);
        capabilities.setCapability("moz:firefoxOptions", options);
        driver = new FirefoxDriver(capabilities);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }


    @Test
    public void testLoadPage()
    {
        driver.get("https://www.google.at/");
    }

    @Test
    public void testLoginSuccess()
    {
        page = new LoginPage(driver, "http://localhost:8080", 30);

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
        page = new LoginPage(driver, "http://localhost:8080", 30);

        // setup + exercise
    	WelcomePage welcome = page.login("student", "password", LoginPage.Group.USER);
    	String message = welcome.getMessage();
        
        // verify
        Assert.assertEquals("Sorry, either your username or password is wrong...", message);
    }

}
