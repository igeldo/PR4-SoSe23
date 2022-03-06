package de.conciso.starter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = AuftragRepresentation.AuftragRepresentationBuilder.class)
public class AuftragRepresentation {

  private String vorname;

  private String name;

  static AuftragRepresentation from(Auftrag auftrag) {
    return new AuftragRepresentation(auftrag.getBestellNummer(), auftrag.getBestellNummer());
  }
}
