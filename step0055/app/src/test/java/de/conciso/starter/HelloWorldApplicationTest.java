package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HelloWorldApplicationTest {

  HelloWorldApplication cut;

  @Nested
  class Given_GreeterMock {

    private GreeterMock greeterMock;

    @BeforeEach
    void arrange() {
      greeterMock = new GreeterMock();
      cut = new HelloWorldApplication(greeterMock);
    }

    @Nested
    class When_calling_run {

      @BeforeEach
      void act() {
        cut.run();
      }

      @Test
      void then_Greeter_is_called_exactly_once() {
        assertThat(greeterMock.getCounter()).isEqualTo(1);
      }

      @Test
      void then_Greeter_is_called_with_name_World() {
        assertThat(greeterMock.getLastArgument()).isEqualTo("World");
      }
    }
  }

  public static class GreeterMock implements Greeter {

    private int counter;
    private String lastArgument;

    @Override
    public String greet(String name) {
      counter++;
      lastArgument = name;
      return "Hallo " + name;
    }

    public int getCounter() {
      return counter;
    }

    public String getLastArgument() {
      return lastArgument;
    }
  }
}
