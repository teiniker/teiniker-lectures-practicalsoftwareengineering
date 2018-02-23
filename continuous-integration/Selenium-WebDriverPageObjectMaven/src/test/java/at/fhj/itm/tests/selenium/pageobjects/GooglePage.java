package at.fhj.itm.tests.selenium.pageobjects;


import org.openqa.selenium.*;

/**
 * Google page according page object pattern.
 * @author CKRENN3
 *
 */
public class GooglePage extends PageObjectBase {

	
	/**
	 * Constructor taking web driver as parameter.
	 * @param driver the web driver.
	 */
	public GooglePage(WebDriver driver) {
		super(driver,"Google");
	}
	
	/**
	 * Searches Google for Selenium and loads Selenium page.
	 * @return The Selenium page. 
	 *
	 */
	public at.fhj.itm.tests.selenium.pageobjects.SeleniumPage searchForSeleniumPage()  {

		WebElement element =	driver.findElement(By.xpath(".//*[@id='lst-ib']"));
		element.clear();
		element.sendKeys("selenium");
		//driver.findElement(By.xpath(".//*[@id='lst-ib']")).submit();
		driver.findElement(By.name("btnG")).click();

		/*
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		*/		
		//driver.findElement(By.xpath(".//*[@id='rso']/div[2]/div[1]/div/h3/a")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		
		// note: click does not wait for page to load, so wait
		WaitForNewPageToLoad(PageObjectBase.DEFAULT_TIMEOUT_SECONDS);	
		
		return new SeleniumPage(driver);
	}
	
	
	
	
}
