package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class HelloWorldControllerTest {

  private static final String NAME = "Georg";
  private static final String GREETINGS = "Hello " + NAME;

  @Mock
  Greeter greeter;

  @InjectMocks
  HelloWorldController cut;

  @Nested
  class Given_the_Greeter_responds {

    @BeforeEach
    void arrange() {
      given(greeter.greet(anyString())).willReturn(GREETINGS);
    }

    @Nested
    class When_calling_sayHello {
      String result;

      @BeforeEach
      void act() {
        result = cut.sayHello(NAME);
      }

      @Test
      void then_Greeter_is_called() {
        verify(greeter).greet(NAME);
      }

      @Test
      void then_result_is_correct() {
        assertThat(result).isEqualTo(GREETINGS);
      }
    }
  }
}
