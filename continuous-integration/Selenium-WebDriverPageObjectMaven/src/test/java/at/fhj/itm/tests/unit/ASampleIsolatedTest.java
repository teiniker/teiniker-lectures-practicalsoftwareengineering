package at.fhj.itm.tests.unit;

import org.junit.*;
import static org.junit.Assert.*;



/**
 * Test example with an isolated unit test.
 * @author CKRENN3
 *
 */
public class ASampleIsolatedTest{
	
	
	/**
	 * Test setup method.
	 * @throws Exception in case of errors
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	/**
	 * Tests something.
	 * 
	 * Bad test example: exposes internals - non functional
	 * 
	 * @throws Exception in case of errors
	 */
	public void testSomething() throws Exception {
		
		
		//Insert some userful testlogic here
		
		String textMessage = "What is ...?";
	
		String text = textMessage;
		
		assertTrue(textMessage.equals(text));
	}
	
	
	/**
	 * Tear down.
	 * @throws Exception in case of errors
	 */
	@After
	public void tearDown() throws Exception {
	}

}
