package es.unizar.webeng.hello;

import org.junit.Before;

/*
 * Import a class called Test, which allows define a test in JUnit
 * */
import org.junit.Test;

import org.junit.runner.RunWith;

/* Imports the SpringFramework's libraries */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.CoreMatchers.*;
/*
* Indicates that the class should use Spring's JUnit facilities. SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner
* which provides functionality of the Spring TestContext Framework
*/

@RunWith(SpringJUnit4ClassRunner.class)
/*
 * SpringApplicationConfiguration is a Class which especifies how to load and
 * configure an ApplicationContext for integration tests.
 */
@SpringApplicationConfiguration(classes = Application.class)

/*
 * @WebAppConfiguration must be present in order to tell Spring that a
 * WebApplicationContext should be loaded for the test
 */
@WebAppConfiguration

/**
 * IntegrationTests
 *
 * Program that performs the integration tests of the application 'hello'
 * Integration tests ensure the proper behaviour of the application and are
 * tipically performed after system and unitary testing.
 *
 */
public class IntegrationTests {

	// Autowire relationships between collaborating beans, in this case, place
	// an instance of WebApplicationContext into wac
	@Autowired
	private WebApplicationContext wac;

	// Default value for message to compare at tests
	@Value("${app.message:Hello World}")
	private String message;

	// Create a new MockMvc object for test which in turn is used perform
	// requests and define expectations.
	private MockMvc mockMvc;

	/*
	 * Sentence to be executed before the test, in order to prepare the base
	 * architecture for the proper functioning of the tests
	 */
	@Before
	public void setup() {
		// Build a MockMvc using the given WebApplicationContext
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * Integration Test to verify Messages
	 *
	 * Running this method will execute the integration test on 'hello'
	 * application, in order to check out the message "message", after
	 * requesting a petition, executing an action and verifying the status of
	 * the type returned by the request.
	 */
	@Test
	public void testMessage() throws Exception {
		// Perform a request and return a type that allows chaining further
		// actions,
		// such as asserting expectations, on the result.
		// Perform a petition
		this.mockMvc.perform(get("/"))
		// Execute action
				.andDo(print()) 
				// Verify status is Ok
				.andExpect(status().isOk()) 
				// Verify attribute "message" in the model equals to the value in the field message
				.andExpect(model().attribute("message", is(message))); 
	}
}
