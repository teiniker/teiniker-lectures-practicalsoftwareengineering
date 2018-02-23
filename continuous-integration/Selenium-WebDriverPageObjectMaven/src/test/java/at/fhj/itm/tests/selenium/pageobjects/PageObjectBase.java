package at.fhj.itm.tests.selenium.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;


/**
 * Page class for all page objects
 * @author CKRENN3
 *
 */
public abstract class PageObjectBase {

	/**
	 * Constant for default timeout
	 */
	public static int DEFAULT_TIMEOUT_SECONDS =1;
	
	/**
	 * The web driver
	 */
	protected WebDriver driver;
	
	/**
	 * The page title
	 */
	protected String title ="";
	
	
	/**
	 * Constructor taking web driver.
	 * @param driver the web driver.
	 */
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Constructor taking web driver and page title.
	 * @param driver the web driver.
	 * @param title the page title
	 */
	public PageObjectBase(WebDriver driver, String title) {
		this.driver = driver;
		this.title = title;
		checkTitle(driver, title);
	}
	
	/**
	 * Set the page title.
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get the page title.
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Checks if page title is present. if not an Exception is thrown.
	 * @param webdriver the web driver
	 * @param titleToCheck the page title to check for.
	 * @exception: IllegalStateException: If page expected page is not loaded.
	 */
	protected static void checkTitle(WebDriver webdriver, String titleToCheck) {
		String currentTitle = webdriver.getTitle();
		if (!titleToCheck.equals(currentTitle)){
			throw new IllegalStateException("Expected page: " + titleToCheck + ". Current Page: " + currentTitle + ". CurrentUrl: " + webdriver.getCurrentUrl());
		}
	
	}
	
	
	/**
	 * Waits for a page to be loaded. Check is done against page title.
	 * @param timeout the time out to wait for.
	 */
	protected void  WaitForNewPageToLoad(int timeout) {
		//Note: Expected Condition has indirected class reference to: 
		//		com.google.common.base.Predicate which is part of selenium-server-standalone-2.28.0.jar 
		//		although WebDriverWait is part of Webdriver package.... why ever...       
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	String myTitle = d.getTitle();
            	return !myTitle.contains(title);
            }
        });
    }
	
}
