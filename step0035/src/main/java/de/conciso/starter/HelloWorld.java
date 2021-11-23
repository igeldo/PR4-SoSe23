package de.conciso.starter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloWorld {

  private static Logger logger = LogManager.getLogger(HelloWorld.class);

  public static void main(String[] args) {
    BasicConfigurator.configure();

    var app = new StarterApplication(new GreeterService());
    app.run();
  }
}
