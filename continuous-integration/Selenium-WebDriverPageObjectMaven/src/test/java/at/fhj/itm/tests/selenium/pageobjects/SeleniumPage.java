package at.fhj.itm.tests.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import at.fhj.itm.tests.selenium.pageobjects.PageObjectBase;


/**
 * Selenium page according page object pattern.
 * @author CKRENN3
 *
 */
public class SeleniumPage extends PageObjectBase {
	
	/**
	 * Constructor taking web driver as parameter.
	 * @param driver the web driver.
	 */
	public SeleniumPage (WebDriver driver) {
		super(driver,"Selenium - Web Browser Automation");
	}

	/**
	 * Checks whether welcome message is present.  
	 * 
	 * Note: Good test function: It is a functional test.
	 * 
	 * @return true if welcome message is present.
	 */
	public  Boolean IsWelcomeMessagePresent(){
		String textMessage = "What is Selenium?";
		String text = GetTextOfxPathElementInternal(".//*[@id='mainContent']/h2[1]");	
		return textMessage.equals(text);
	}
	
	
	/**
	 * Checks whether a given welcome message is present.  
	 * 
	 * OK test function: It is a functional test but takes string as parameter (caller must know details)
	 * 
	 *  @param message the message to check on page.
	 * @return true if welcome message is present.
	 */
	public Boolean IsMessagePresent(String message){
		String text = GetTextOfxPathElementInternal(".//*[@id='mainContent']");
		return text.contains(message);
	}
	
	/**
	 * Checks whether a given xpath message is present. 
	 * @param xPathElement the xpath element to check on page.
	 * @return if xpath element is present.
	 */
	public  String GetTextOfxPathElement(String xPathElement){
		return GetTextOfxPathElementInternal(xPathElement);
	}
	
	/**
	 * Get the text of given xpath element.
	 * @param xPathElement the element.
	 * @return the text of the element.
	 */
	private  String GetTextOfxPathElementInternal(String xPathElement){
		String text = driver.findElement(By.xpath(xPathElement)).getText();
		return text;
	}
	
	
}
