package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static final Logger logger = LogManager.getLogger(HelloWorldController.class);

  private final Greeter greeter;

  public HelloWorldController(Greeter greeter) {
    this.greeter = greeter;
  }

  @GetMapping(value = "/api/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String sayHello(@RequestParam("name") String name) {
    var greetings = greeter.greet(name);
    logger.info("response: " + greetings);
    return greetings;
  }
}
