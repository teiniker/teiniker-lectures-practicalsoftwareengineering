package org.se.lab;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.se.lab.pages.LoginPage;
import org.se.lab.pages.LoginPageBuilder;
import org.se.lab.pages.WelcomePage;

import java.util.concurrent.TimeUnit;

/*
 * Use an ExpressionBuilder to create a fluent interface on top of a PageObject.
 */

public class FirefoxTestWithBuilder
{
    private LoginPage page;
    private WebDriver driver;

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.gecko.driver","/home/student/install/geckodriver/geckodriver");
    }

    @Before
    public void setUp()
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
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void testLoginSuccess()
    {
        // setup
        LoginPage page = new LoginPageBuilder(driver)
                .username("student")
                .password("student")
                .asUser()
                .build();
        // TODO: Builder with default values, e.g. role only
        
        // exercise
        WelcomePage welcome = page.login();

        // verify
        Assert.assertEquals("Welcome, student!", welcome.getMessage());
    }
    
    
    @Test
    public void testLoginTestFailure()
    {
        page = new LoginPage(driver, "http://localhost:8080", 30);

        // setup
        LoginPage page = new LoginPageBuilder(driver)
                .username("student")
                .password("password")
                .asUser()
                .build();

        // execute
        WelcomePage welcome = page.login();

        // verify
        Assert.assertEquals("Sorry, either your username or password is wrong...", welcome.getMessage());
    }
}
