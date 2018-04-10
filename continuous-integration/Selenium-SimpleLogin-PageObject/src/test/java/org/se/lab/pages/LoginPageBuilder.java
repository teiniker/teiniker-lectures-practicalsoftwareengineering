package org.se.lab.pages;

import org.openqa.selenium.WebDriver;

public class LoginPageBuilder
{
    private WebDriver driver;

    private String baseUrl = "http://localhost:8080"; // default value
    private int timeout = 30;   // default value
    private String username;
    private String password;
    private LoginPage.Group group;

    public LoginPageBuilder(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPageBuilder baseUrl(String url)
    {
        this.baseUrl = url;
        return this;
    }

    public LoginPageBuilder timeout(int timeout)
    {
        this.timeout = timeout;
        return this;
    }


    public LoginPageBuilder username(String username)
    {
        this.username = username;
        return this;
    }

    public LoginPageBuilder password(String password)
    {
        this.password = password;
        return this;
    }

    public LoginPageBuilder asGuest()
    {
        this.group = LoginPage.Group.GUEST;
        return this;
    }

    public LoginPageBuilder asUser()
    {
        this.group = LoginPage.Group.USER;
        return this;
    }

    public LoginPageBuilder asAdmin()
    {
        this.group = LoginPage.Group.ADMIN;
        return this;
    }

    public LoginPage build()
    {
        LoginPage page = page = new LoginPage(driver,baseUrl,timeout);
        page.setUsername(username);
        page.setPassword(password);
        page.setUsergroup(group);
        return page;
    }

}
