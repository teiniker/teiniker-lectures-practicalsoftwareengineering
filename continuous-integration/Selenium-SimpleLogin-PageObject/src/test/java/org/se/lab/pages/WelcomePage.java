package org.se.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage
{
	private WebDriver driver;
	
	/*
     * Constructor
     */
	
	public WelcomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	/*
     * Text: <h2>message</h2>
     */
	public String getMessage()
	{
		return driver.findElement(By.cssSelector("h2")).getText();
	}
}
