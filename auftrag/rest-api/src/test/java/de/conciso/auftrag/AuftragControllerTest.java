package de.conciso.auftrag;

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
class AuftragControllerTest {

  @Mock
  Auftraege auftraege;

  @InjectMocks
  AuftragController cut;

  @Nested
  class Given_Auftrag_can_be_created {

    @BeforeEach
    void arrange() {
      given(auftraege.create(anyString())).willReturn(new Auftrag(42,"someBestellNummer"));
    }

    @Nested
    class When_calling_create {
      ResponseEntity<AuftragRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.create("someBestellNummer");
      }

      @Test
      void then_AuftraegeService_is_called() {
        verify(auftraege).create("someBestellNummer");
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_body_is_correct() {
        var expected = new AuftragRepresentation(42,"someBestellNummer");
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_Auftrag_can_be_found {

    @BeforeEach
    void arrange() {
      given(auftraege.findById(anyInt())).willReturn(Optional.of(new Auftrag(42,"someBestellNummer")));
    }

    @Nested
    class When_calling_find {
      ResponseEntity<AuftragRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findById(42);
      }

      @Test
      void then_AuftraegeService_is_called() {
        verify(auftraege).findById(42);
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_body_is_correct() {
        var expected = new AuftragRepresentation(42,"someBestellNummer");
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_Auftrag_cannot_be_found {

    @BeforeEach
    void arrange() {
      given(auftraege.findById(anyInt())).willReturn(Optional.empty());
    }

    @Nested
    class When_calling_find {
      ResponseEntity<AuftragRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findById(42);
      }

      @Test
      void then_AuftraegeService_is_called() {
        verify(auftraege).findById(42);
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
