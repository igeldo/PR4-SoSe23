package de.conciso.shop;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuftragRepresentation {

  int id;
  String bestellNummer;
  LieferadresseRepresentation lieferadresse;

  public static AuftragRepresentation from(Auftrag auftrag) {
    return AuftragRepresentation.builder()
        .id(auftrag.getId())
        .bestellNummer(auftrag.getBestellNummer())
        .lieferadresse(LieferadresseRepresentation.from(auftrag.getLieferadresse()))
        .build();
  }
}
