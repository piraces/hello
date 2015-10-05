package es.unizar.webeng.hello;



/*
 * Import a class called Test, which allows define a test in JUnit
 * */
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

/* Imports the SpringFramework's libraries */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

 /*
  * Indicates that the class should use Spring's JUnit facilities. 
  * SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner
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

 /*
  * The application will start at a random free port, caching it throughout all
  * unit tests
  */
@IntegrationTest("server.port=0")

 /*
  * Indicates that the ApplicationContext associated with a test is "dirty" and
  * should therefore be closed and removed from the context cache
  */
@DirtiesContext

 /**
  * SystemTests
  * Program that performs the system tests of the application 'hello' System
  * tests look for discrepancies between the program and the objective or
  * requirement , focusing on the mistakes made during the transition process to
  * design the functional specification.
  * 
  */
public class SystemTests {

  // It will contain the random port
  @Value("${local.server.port}")
  private int port = 0;
  
 /**
  * Method that can be executed in order to test the connection to the Home
  * page If something goes wrong (the connection fails or the page has a
  * wrong body), this method throws an Exception
  * 
  * @throws Exception
  *             if the connection has failed or the page has a wrong body.
  */
  @Test
  public void testHome() throws Exception {
   /*
    * Information given by a GET petition to the URL specified
    * is stored on an Entity
    */
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port,
                     String.class);

   /*
    * Check if the status is OK, this means code is 200 so is reachable
    */
    assertEquals(HttpStatus.OK, entity.getStatusCode());

   /* 
    * Check if the page's title starts with Hello, if it doesn't it throws
    * an error
    */
    assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(), 
             entity.getBody().contains("<title>Hello"));
  }

 /**
  * Method that can be executed in order to test the connection to styles
  * sheet If the connection goes wrong or the CSS file is not well formed, this
  * method throws an Exception
  * 
  * @throws Exception
  *             if the connection to the styles sheet is wrong or if it's bad
  *             formed.
  */
  @Test
  public void testCss() throws Exception {
   /*
    * Information given by a GET petition to the URL specified by the first
    * parameter is stored on an ResponseEntity.
    */
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                     "http://localhost:" + this.port + "/webjars/bootstrap/3.3.5/css/bootstrap.min.css", String.class);

   /*
    * Checks done for verifying the correctness of the connection with these three
    * assertions who will
    * return an exception if one of them is not correct.
    */

   /*
    * Check if the StatusCode is equal to 200 (HttpStatus.OK) which is the
    * standard response
    * for successful HTTP requests. If correct, it means that is available
    * to connect and the connection has been successful.
    */
    assertEquals(HttpStatus.OK, entity.getStatusCode());

   /*
    * These assertion check if the information given by the GET petition
    * (if the body of the GET petition is
    * correct(contains the word 'body')), which has been saved in an
    * entity, contains a correct CSS format.
    * For more information about CSS (Cascading Style Sheets), you can read
    * about it in the
    * W3C page (http://www.w3.org/TR/CSS/) or in the W3 schools page
    * (http://www.w3schools.com/css/)
    * If the verification is not positive it throws an error with the given
    * message.
    */
    assertTrue("Wrong body:\n" + entity.getBody(), entity.getBody().contains("body"));

   /*
    * Checks if the 'Content-type' field of the GET petition is correct.
    * If the verification is not positive it throws an error with the given
    * message.
    */
    assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(),
                  MediaType.valueOf("text/css;charset=UTF-8"), 
                  entity.getHeaders().getContentType());
  }

 /**
  * Method that can be executed in order to test if Head.png is being served.
  * @throws Exception if the image is not being served
  */
  @Test
  public void testHead() throws Exception {

   /*  
    * Information given by a GET petition to the URL specified by the first
    * parameter is stored on an ResponseEntity.
    */
    ResponseEntity<byte[]> entity = new TestRestTemplate()
                 .getForEntity("http:/" + "/localhost:" 
                 + this.port + "/images/Head.png", byte[].class);

   /*
    * Check if the StatusCode is equal to 200 (HttpStatus.OK) which is the standard response
    * for succesful HTTP requests. If correct, it means that is available to connect and the
    * connection has been succesful.
    */
  
    assertEquals(HttpStatus.OK, entity.getStatusCode());
  
   /* 
    * Checks if the 'Content-type' field of the GET petition is correct. This means,
    * the returned entity is a PNG file. If the verification is not positive it throws
    * an error with the given message.
    */
    assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(),
               MediaType.valueOf("image/png;charset=UTF-8"), entity.getHeaders().getContentType());
  }
}
