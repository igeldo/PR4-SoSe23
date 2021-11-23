package de.conciso.starter;

import org.apache.log4j.BasicConfigurator;

public class HelloWorld {

  public static void main(String[] args) {
    BasicConfigurator.configure();

    var app = new StarterApplication(new GreeterService());
    app.run();
  }
}
