package de.conciso.auftrag;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class AuftragControllerTest {

  private static final String BESTELL_NUMMER = "someBestellNummer";
  private static final int ID = 42;

  @Mock
  Auftraege auftraege;

  @InjectMocks
  AuftragController cut;

  @Nested
  class Given_testAuftrag {

    private AuftragRepresentation testAuftragRepresentation;
    private Auftrag testAuftrag;
    private Auftrag testAuftragWithId;
    private AuftragRepresentation expectedAuftragRepresentation;

    @BeforeEach
    void arrange() {
      testAuftragRepresentation = AuftragRepresentation.builder()
          .bestellNummer(BESTELL_NUMMER)
          .build();
      testAuftrag = new Auftrag(BESTELL_NUMMER);
      testAuftragWithId = new Auftrag(ID, BESTELL_NUMMER);
      expectedAuftragRepresentation = AuftragRepresentation.builder()
          .bestellNummer(BESTELL_NUMMER)
          .artikel(List.of())
          .build();
    }

    @Nested
    class Given_Auftrag_can_be_created {

      @BeforeEach
      void arrange() {
        given(auftraege.create(any(Auftrag.class))).willReturn(testAuftragWithId);
      }

      @Nested
      class When_calling_create {
        ResponseEntity<AuftragRepresentation> result;

        @BeforeEach
        void act() {
          result = cut.create(testAuftragRepresentation);
        }

        @Test
        void then_AuftraegeService_is_called() {
          verify(auftraege).create(testAuftrag);
        }

        @Test
        void then_status_is_OK() {
          assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        void then_body_is_correct() {
          assertThat(result.getBody()).isEqualTo(expectedAuftragRepresentation);
        }
      }
    }

    @Nested
    class Given_Auftrag_can_be_found {

      @BeforeEach
      void arrange() {
        given(auftraege.findById(anyInt())).willReturn(Optional.of(testAuftragWithId));
      }

      @Nested
      class When_calling_findById {
        ResponseEntity<AuftragRepresentation> result;

        @BeforeEach
        void act() {
          result = cut.findById(ID);
        }

        @Test
        void then_AuftraegeService_is_called() {
          verify(auftraege).findById(ID);
        }

        @Test
        void then_status_is_OK() {
          assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        void then_body_is_correct() {
          assertThat(result.getBody()).isEqualTo(expectedAuftragRepresentation);
        }
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
    class When_calling_findById {
      ResponseEntity<AuftragRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findById(ID);
      }

      @Test
      void then_AuftraegeService_is_called() {
        verify(auftraege).findById(ID);
      }

      @Test
      void then_status_is_NOT_FOUND() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      }

      @Test
      void then_body_is_empty() {
        assertThat(result.hasBody()).isFalse();
      }
    }
  }
}
