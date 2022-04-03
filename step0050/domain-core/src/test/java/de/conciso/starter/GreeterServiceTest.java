package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GreeterServiceTest {

  GreeterService cut;

  @BeforeEach
  void init() {
    cut = new GreeterService();
  }

  @Test
  void when_calling_greet_result_is_Hello_Georg() {
    // Arrange
    var name = "Georg";

    // Act
    var result = cut.greet(name);

    // Assert
    assertThat(result).isEqualTo("Hello Georg");
  }

  @Nested
  class Given_name_is_Georg {
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

  @Nested
  class Given_name_is_null {
    String name;

    @BeforeEach
    void arrange() {
      name = null;
    }

    @Nested
    class When_calling_greet {
      String result;

      @BeforeEach
      void act() {
        result = cut.greet(name);
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
      void then_result_is_Hello_null() {
        assertThat(result).isEqualTo("Hello null");
      }
    }
  }
}
