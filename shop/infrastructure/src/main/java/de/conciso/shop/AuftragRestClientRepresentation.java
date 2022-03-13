package de.conciso.shop;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
public class AuftragRestClientRepresentation {

  int id;
  String bestellNummer;
  LieferadresseRestClientRepresentation lieferadresse;

  public Auftrag toAuftrag() {
    return Auftrag.builder()
        .id(id)
        .bestellNummer(bestellNummer)
        .lieferadresse(lieferadresse.toLieferadresse())
        .build();
  }

  public static AuftragRestClientRepresentation from(Auftrag auftrag) {
    return AuftragRestClientRepresentation.builder()
        .bestellNummer(auftrag.getBestellNummer())
        .lieferadresse(LieferadresseRestClientRepresentation.from(auftrag.getLieferadresse()))
        .build();
  }
}
