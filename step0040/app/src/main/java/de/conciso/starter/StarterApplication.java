package de.conciso.starter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StarterApplication {

  private static Logger logger = LogManager.getLogger(StarterApplication.class);

  private Greeter greeter;

  public StarterApplication(Greeter greeter) {
    this.greeter = greeter;
  }

  public void run() {
    logger.info(greeter.greet("World"));
  }
}
