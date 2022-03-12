package de.conciso.auftrag;

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
    return lieferadresse == null ? null : LieferadresseRepresentation.builder()
        .name(lieferadresse.getName())
        .strasse(lieferadresse.getStrasse())
        .plz(lieferadresse.getPlz())
        .ort(lieferadresse.getOrt())
        .build();
  }

  public Lieferadresse toLieferadresse() {
    return new Lieferadresse(name, strasse, plz, ort);
  }
}
