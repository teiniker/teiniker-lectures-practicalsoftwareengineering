package org.se.lab;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.se.lab.pages.LoginPage;
import org.se.lab.pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class LoginPageTest
{
    private LoginPage page;
    private WebDriver driver;

    @BeforeClass
    public static void init()
    {
  //      FirefoxDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() throws Exception
    {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
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
    public void testLoginSuccess() throws Exception
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
