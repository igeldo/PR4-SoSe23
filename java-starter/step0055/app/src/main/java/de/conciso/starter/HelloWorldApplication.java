package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldApplication {

  private static Logger logger = LogManager.getLogger(HelloWorldApplication.class);

  private final Greeter greeter;

  public HelloWorldApplication(Greeter greeter) {
    this.greeter = greeter;
  }

  public void run() {
    logger.info(greeter.greet("World"));
  }
}
