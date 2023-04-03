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
import org.springframework.http.ResponseEntity;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

  @Mock
  Personen personen;

  @InjectMocks
  PersonController cut;

  @Nested
  class Given_Person_can_be_created {

    @BeforeEach
    void arrange() {
      given(personen.create(anyString(), anyString())).willReturn(new Person("Hugo", "Tester"));
    }

    @Nested
    class When_calling_create {
      ResponseEntity<Person> result;

      @BeforeEach
      void act() {
        result = cut.create("Hugo", "Tester");
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).create("Hugo", "Tester");
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_body_is_correct() {
        assertThat(result.getBody()).isEqualTo(new Person("Hugo", "Tester"));
      }
    }
  }
}
