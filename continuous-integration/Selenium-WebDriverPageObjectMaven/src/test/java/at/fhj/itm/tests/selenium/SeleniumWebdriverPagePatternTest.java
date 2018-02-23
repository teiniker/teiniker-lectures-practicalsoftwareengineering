package at.fhj.itm.tests.selenium;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import at.fhj.itm.tests.selenium.pageobjects.GooglePage;
import at.fhj.itm.tests.selenium.pageobjects.SeleniumPage;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.concurrent.TimeUnit;

/**
 * Test example showing how to implement Page object pattern with selenium 3.
 * @author CKRENN3
 *
 */
public class SeleniumWebdriverPagePatternTest{
	
	/**
	 * Webdriver object	
	 */
	private WebDriver driver;
	
	/*
	 * Enum for WebDrivers
	 */
	public static enum DriverType {Firefox, Chrome};
	/*
	 * DriverType
	 */
	public static DriverType drivertype = DriverType.Firefox;
	
	 @BeforeClass
	 /**
	  * 
	  */
	  public static void setupClass() {
	     
		 if (drivertype.equals(DriverType.Firefox) ){
			 FirefoxDriverManager.getInstance().setup();
		     //for 32 bit set x32 / for 64 bit set x64
			 //FirefoxDriverManager.getInstance().setup(Architecture.x32);
		 }
		 else {
			 ChromeDriverManager.getInstance().setup();
		 }
	  }
	
	/**
	 * Test setup method.
	 * @throws Exception in case of errors
	 */
	@Before
	public void setUp() throws Exception {
		
		if (drivertype.equals(DriverType.Firefox) ){
			driver = new FirefoxDriver();
		}else{
			driver = new ChromeDriver();
		}
		//comment out for testing purposes -> to show exceptions
		//set timeout for handling element load
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.at/");
	}

	@Test
	@Ignore
	/**
	 * Searches Google for Selenium and loads selenium home page.
	 * 
	 * Bad test example: exposes internals - non functional
	 * 
	 * @throws Exception in case of errors
	 *
	public void testSearchSeleniumPageWithGoogleAndValidateSeleniumPageBadExample() throws Exception {
		
		GooglePage googlePage = new GooglePage(driver);
		SeleniumPage seleniumPage = googlePage.searchForSeleniumPage();
		
		String textMessage = "What is Selenium?";
	
		//the ugly part.
		String text = seleniumPage.GetTextOfxPathElement(".//*[@id='mainContent']/h2[1]");
		
		assertTrue(textMessage.equals(text));
	}
	*/
	@Test
	@Ignore
	/**
	 * 
	 * Searches Google for Selenium and loads selenium home page.
	 * 
	 * better test example: does not expose internal - functional but exposes internals
	 * @throws Exception
	 *
	public void testSearchSeleniumPageWithGoogleAndValidateSeleniumPageBetterExample() throws Exception {
		
		GooglePage googlePage = new GooglePage(driver);
		SeleniumPage seleniumPage = googlePage.searchForSeleniumPage();
		
		//better: define functional string, but what if selenium page content changes? change every test?
		String textMessage = "What is Selenium?";
		assertTrue(seleniumPage.IsMessagePresent(textMessage));
	}
	*/
	@Test
	/**
	 * Searches Google for Selenium and loads Selenium home page.
	 * 
	 * Good test example - fully functional - page pattern optimized
	 * 
	 * 	@throws Exception in case of errors
	 */
	public void testSearchSeleniumPageWithGoogleAndValidateSeleniumPage() throws Exception {
		
		GooglePage googlePage = new GooglePage(driver);
		SeleniumPage seleniumPage = googlePage.searchForSeleniumPage();
		
		assertTrue(seleniumPage.IsWelcomeMessagePresent());
	}
	
	
	/**
	 * Tear down.
	 * @throws Exception in case of errors
	 */
	@After
	public void tearDown() throws Exception {
		//note: when firefox throws abort exception don't worry: https://github.com/mozilla/geckodriver/issues/339
		driver.quit();
	}

}
