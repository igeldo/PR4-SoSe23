package de.conciso.starter;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Nested
    class When_calling_sayHelloWithPathVariable {
      String result;

      @BeforeEach
      void act() {
        result = cut.sayHelloWithPathVariable(name);
      }

      @Test
      void then_result_is_Hello_Georg() {
        assertThat(result).isEqualTo("Hello Georg");
      }
    }
  }
}
