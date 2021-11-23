package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GreeterServiceTest {

  GreeterService cut = new GreeterService();

  @Nested
  class Given_a_name_Georg {
    String name;

    @BeforeEach
    void arrange() {
      name = "Georg";
    }

    @Nested
    class When_calling_greet {
      String result;

      @BeforeEach
      void act() {
        result = cut.greet(name);
      }

      @Test
      void then_result_is_Hello_Georg() {
        assertThat(result).isEqualTo("Hello Georg");
      }
    }
  }
  @Nested
  class Given_a_name_Burkhard {
    String name;

    @BeforeEach
    void arrange() {
      name = "Burkhard";
    }

    @Nested
    class When_calling_greet {
      String result;

      @BeforeEach
      void act() {
        result = cut.greet(name);
      }

      @Test
      void then_result_is_Hello_Burkhard() {
        assertThat(result).isEqualTo("Hello Burkhard");
      }
    }
  }
}
