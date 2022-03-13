package de.conciso.shop;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LieferadresseRepresentation {

  String name;
  String strasse;
  int plz;
  String ort;

  static LieferadresseRepresentation from(Lieferadresse lieferadresse) {
    return LieferadresseRepresentation.builder()
        .name(lieferadresse.getName())
        .strasse(lieferadresse.getStrasse())
        .plz(lieferadresse.getPlz())
        .ort(lieferadresse.getOrt())
        .build();
  }
}
