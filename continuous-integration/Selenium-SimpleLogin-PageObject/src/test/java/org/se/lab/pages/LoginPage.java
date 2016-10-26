package org.se.lab.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginPage
{
    private WebDriver driver;
    private String baseUrl;
    
    /*
     * Constructor
     */
    public LoginPage(WebDriver driver, String baseUrl, int timeout)
    {
        this.driver = driver;
        this.baseUrl = baseUrl;
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
    

    /*
     * Input field: username:String
     */
    private String username;
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    
    /*
     * Input field: password:String
     */
    private String password;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
        
    /*
     * Input field: usergroup:Group
     */
    public enum Group 
    {
        GUEST(1, "Guest"), 
        USER(2, "User"), 
        ADMIN(3, "Administrator");
    
        private final int value;
        private final String name;
        private Group(int value, String name)
        {
            this.value = value;
            this.name = name;
        }
    }
    private Group usergroup;
    public Group getUsergroup()
    {
        return usergroup;
    }
    public void setUsergroup(Group usergroup)
    {
        this.usergroup = usergroup;
    }
    
    
    /*
     * Action: Reset
     */
    


    /*
     * Action: Login
     */
    public WelcomePage login()
    {
        driver.get(baseUrl + "/Servlet-SimpleLogin/index.html");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(getUsername());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(getPassword());
        new Select(driver.findElement(By.name("usergroup"))).selectByVisibleText(getUsergroup().name);
        driver.findElement(By.xpath("(//input[@name='action'])[" + getUsergroup().value + "]")).click();
        
        return new WelcomePage(driver);
    }

    public WelcomePage login(String username, String password, Group usergroup)
    {
        setUsername(username);
        setPassword(password);
        setUsergroup(usergroup);
        return login();
    }
}
