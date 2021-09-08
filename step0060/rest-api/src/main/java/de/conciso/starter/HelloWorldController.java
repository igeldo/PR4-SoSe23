package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static Logger logger = LogManager.getLogger(HelloWorldController.class);

  @GetMapping(value = "/api/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String sayHello(@RequestParam("name") String name) {
    var greeter = new GreeterService();
    var greetings = greeter.greet(name);
    logger.info("response: " + greetings);
    return greetings;
  }
}
