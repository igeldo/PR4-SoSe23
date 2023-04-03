package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HelloWorldControllerTest {

  HelloWorldController cut;

  @BeforeEach
  void init() {
    cut = new HelloWorldController();
  }

  @Nested
  class Given_name_is_Georg {
    String name;

    @BeforeEach
    void arrange() {
      name = "Georg";
    }

    @Nested
    class When_calling_sayHello {
      String result;

      @BeforeEach
      void act() {
        result = cut.sayHello(name);
      }

      @Test
      void then_result_is_not_null() {
        assertThat(result).isNotNull();
      }

      @Test
      void then_result_contains_Hello() {
        assertThat(result).contains("Hello");
      }

      @Test
      void then_result_is_Hello_Georg() {
        assertThat(result).isEqualTo("Hello Georg");
      }
    }
  }
}
