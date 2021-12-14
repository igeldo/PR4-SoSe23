package de.conciso.starter;

import org.springframework.stereotype.Service;

@Service
public class GreeterService implements Greeter {

  @Override
  public String greet(String name) {
    return "Hello " + name;
  }
}
