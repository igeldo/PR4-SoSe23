package de.conciso.starter;

public class HelloWorld {

  public static void main(String[] args) {
    var app = new StarterApplication(new GreeterService());
    app.run();
  }
}
