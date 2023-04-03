package de.conciso.starter;

public class Starter {

  public static void main(String[] args) {
    var greeter = new GreeterService();
    var application = new HelloWorldApplication(greeter);
    application.run();
  }
}
