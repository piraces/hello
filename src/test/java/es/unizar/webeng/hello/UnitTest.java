package es.unizar.webeng.hello;

/* Imports the CoreMatchers object that will be used
 * to examine if the specified objects match with the
 * given matchers.
 */
import static org.hamcrest.CoreMatchers.*;
/*
 * Imports the Assert object that will contain a set
 * of assertion methods (CoreMatchers, for example) and
 * could be useful for writing methods. Failed assertions
 * will be the only ones recorded.
 */
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;



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
  @Value("${app.message:Hello World}")
  private String message;

  // Place an instance of HelloController into field
  @Autowired
  private HelloController controller;

 /**
  * The function run the unity tests, if a test fail, the function will throw
  * a Exception
  *
  * Running this function will execute the unity tests on 'hello' application,
  * checking that all its parts are correct (messages, if the Date object
  * does or does not exists and, in that case, if the Date on the time field
  * is correct or not). Failing in any of the test will result on an
  * exception, thrown by the function.
  *
  * @throws Exception
  */
  @Test
  public void testMessage() throws Exception {

    HashMap<String, Object> map = new HashMap<>();
    String view = controller.welcome(map);   


   /*
    * It checks that the message returned by 'controller.welcome()' is
    * correct ("welcome")
    */
    assertThat(view, is("welcome"));
   /*
    * It checks that the field 'message' has been added successfully to the
    * map
    */
    assertThat(map.containsKey("message"), is(true));
    // Check that the time field contain a Date object
    assertThat(map.get("time"), instanceOf(Date.class));
    // Check that the Date is correct
    Date date = ((Date) map.get("time"));
   /*
    * An exception is thrown if the date given by 'controller.welcome()' is
    * later to date 'now'
    */
    Date now = new Date();
    assertThat(date.after(now), is(false));
  }

 /**
  * This test verificate the correct execution of the method "userdaata()"
  * @throws Exception
  */
  @Test
  public void testUserdata() throws Exception {
    String view = controller.userdata();
   /*
    * It checks that the message returned by 'controller.userdata()' is
    * correct ("userdata")
    */
    assertThat(view, is("userdata"));
  }
}