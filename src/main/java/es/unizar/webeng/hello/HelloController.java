package es.unizar.webeng.hello;

/* Imports the SpringFramework's libraries */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/* Imports java utilities */

import java.util.Date;
import java.util.Map;


/**
 * The annotation @Controller indicates that HelloController 
 * takes the role of a controller
 */
@Controller
public class HelloController {
 /**
  * @countReq Request counter
  */
  private transient int countReq;
  
 /**
  * @secondsRunning Seconds running the app
  */  
  private transient int secondsRunning;
  
 /**
  * @LOGGER Declares logger on this class
  */
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
  
 /**
  * The annotation @Value is used to set a default value
  * from properties file
  */
  @Value("${app.message:Hello World}")
  private transient String message;
  
 /**
  * The annotation @RequestMapping is used by Spring to
  * know which Controller or which Controller’s method must
  * each http customer call be addressed to.
  * In this case,
  * we are informing that every http customer call to the
  * homepage, which was a request of GET kind,
  * is going to be managed by the public method
  * named “welcome” of our Controller.
  */
  @RequestMapping(value = "/", method = RequestMethod.GET)


 /**
  * It is called when a HTTP request is made to the root path and the request was 
  * GET kind , as indicated @RequestMapping(value="/", method=RequestMethod.GET) 
  * In addition, it makes two new entries in the Map of Strings (as key)
  * and Objects (as value) passed by parameter. The first one has the key 
  * “time”, and its value is a Date object which manages the current date.
  * The second one has the key “message”, and its value is the
  * reference to the String identified by “message” explained before.
  * @param model This parameter is used for passing data from the controller 
  *     to the view.
  *     Controller adds key-value pairs to the model and the view access them with 
  *     the ${key} syntax. When rendering, ${key} is replaced with its value.
  * @return The name of the view responsible for rendering the HTML page. 
  *     As "welcome" is returned, "welcome.jsp" file will render the page.
  */
  public String welcome(final Map<String, Object> model) {
    // Each request to the root path is counted
    this.countReq += 1;
   /* It is made the first entry in the Map. Displays the current date and time, 
    * including the day of the week, the time zone and the Daylight Saving Time
    * or the Winter Time 
    */
    model.put("time", new Date());
   /* It is made the second entry in the Map. Displays the message, by default, 
    * his value is defined in the application properties, located in
    * the main app resources 
    */
    model.put("message", message);
    return "welcome";
  }

 /**
  * It is called when a HTTP request is made to the root path and the request was 
  * GET kind , as indicated @RequestMapping(value="/", method=RequestMethod.GET)
  *
  * @return The name of the view responsible for rendering the HTML page. 
  *     As "userdata" is returned, "userdata.jsp" file will render the page.
  */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String userdata() {
    //Each request to userdata page is counted
    countReq += 1;
    return "userdata";
  }

 /**
  * The @Scheduled annotation indicates this method can be performed
  * periodically according to the parameter that is assigned milliseconds.
  */
  @Scheduled(fixedRate = 60000)

   /** 
    * This method sends info level log messages with information about
    * the apps's execution such as the actual date, the time it has been running
    * and the number of requests that have been made to the root page. 
    * It is called every minute.
    */
  public void infoServer() {
    if (LOGGER.isInfoEnabled()) {
      LOGGER.info(new Date() + ": Server has been running for " + secondsRunning + " seconds");
      LOGGER.info(countReq + " resquests have been made since the server started");
    }
  }

 /**
  * The @Scheduled annotation indicates this method can be performed 
  * periodically according to the parameter that is assigned milliseconds.
  */
  @Scheduled(fixedRate = 1000)
 /** 
  * This method increments the seconds the server has been running by 
  * one every one second.
  */
  public void updateMilisRunning() {
    this.secondsRunning += 1;
  }
}