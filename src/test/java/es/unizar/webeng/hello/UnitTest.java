package es.unizar.webeng.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.HashMap;
import java.util.Date;

/* Imports the CoreMatchers object that will be used
 * to examine if the specified objects match with the
 * given matchers.
 */
import static org.hamcrest.CoreMatchers.is;
/*
 * Imports the Assert object that will contain a set
 * of assertion methods (CoreMatchers, for example) and
 * could be useful for writing methods. Failed assertions
 * will be the only ones recorded.
 */
//import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
/*
* Indicates that the class should use Spring's JUnit facilities. 
* SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner
* which provides functionality of the Spring TestContext Framework
*/

// JUnit4 invoke SpringJUnit4ClassRunner class
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * Class used to determinate how to load and configure an ApplicationContext for
 * integration tests
 */
@SpringApplicationConfiguration(classes = Application.class)

/**
 * UnitTest
 *
 * Program that performs the unit test of the application 'hello' Unit tests
 * check the proper behavior of a code module to ensure that each module works
 * properly separately.
 * 
 */
public class UnitTest {

	// Set the default value from the config file: application.properties
	//@Value("${app.message:Hello World}")
	//private String message;

	/**
	 * Converts the literal into a varible
	 */
	private final static String WELCOME = "welcome";
	
	/**
	 * Place an instance of HelloController into field
	 */
	@Autowired
	private transient HelloController controller;

	/**
	 * The function run the unity tests, if a test fail, the function will throw
	 * a Exception
	 */
	 
	/**
	 * Running this function will execute the unity tests on 'hello' application,
	 * checking that all its parts are correct (messages, if the Date object
	 * does or does not exists and, in that case, if the Date on the time field
	 * is correct or not). Failing in any of the test will result on an
	 * exception, thrown by the function.
	 */
	@Test
	public void testMessage() throws Exception {
		final HashMap<String, Object> map = new HashMap<>();
		final String view = controller.welcome(map);
		// It checks that the message returned by 'controller.welcome()' is
		// correct ("welcome")
		// It checks that the field 'message' has been added successfully to the
		// map
		// Check that the time field contain a Date object
		// Check that the Date is correct
		if (WELCOME.equals(view) && map.containsKey("message") && map.get("time") instanceof Date){
			final Date date = ((Date) map.get("time"));
			final Date now = new Date();
			// An exception is thrown if the date given by 'controller.welcome()' is
			// later to date 'now'
			assertThat(date.after(now), is(false));
		}
		else {
			fail();
		}
 	}
	
	/**
	 * This test verificate the correct execution of the method "userdaata()"
	 * @throws Exception
	 */
	@Test
	public void testUserdata() throws Exception {
	final String view = controller.userdata();
	// It checks that the message returned by 'controller.userdata()' is
		// correct ("userdata")
		assertThat(view, is("userdata"));
 	}
}
