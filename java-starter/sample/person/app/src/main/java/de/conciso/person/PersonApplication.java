package de.conciso.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PersonApplication {
  public static void main(String[] args) {
    SpringApplication.run(PersonApplication.class, args);
  }

}
