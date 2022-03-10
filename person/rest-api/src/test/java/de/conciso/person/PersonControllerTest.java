package de.conciso.person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

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
      given(personen.create(anyString(), anyString())).willReturn(new Person(42,"Hugo", "Test"));
    }

    @Nested
    class When_calling_create {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.create("Hugo", "Test");
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).create("Hugo", "Test");
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_body_is_correct() {
        var expected = new PersonRepresentation(42,"Hugo", "Test");
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_Person_can_be_found {

    @BeforeEach
    void arrange() {
      given(personen.findById(anyInt())).willReturn(Optional.of(new Person(42,"Hugo", "Test")));
    }

    @Nested
    class When_calling_find {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findById(42);
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).findById(42);
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_body_is_correct() {
        var expected = new PersonRepresentation(42,"Hugo", "Test");
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_Person_cannot_be_found {

    @BeforeEach
    void arrange() {
      given(personen.findById(anyInt())).willReturn(Optional.empty());
    }

    @Nested
    class When_calling_find {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findById(42);
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).findById(42);
      }

      @Test
      void then_status_is_NOT_FOUND() {
        assertThat(result.getStatusCodeValue()).isEqualTo(404);
      }

      @Test
      void then_body_is_empty() {
        assertThat(result.hasBody()).isFalse();
      }
    }
  }
}
