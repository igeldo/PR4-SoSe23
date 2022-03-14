package de.conciso.shop;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
public class LieferadresseRestClientRepresentation {

  String name;
  String strasse;
  int plz;
  String ort;

  public Lieferadresse toLieferadresse() {
    return Lieferadresse.builder()
        .name(name)
        .strasse(strasse)
        .plz(plz)
        .ort(ort)
        .build();
  }

  public static LieferadresseRestClientRepresentation from(Lieferadresse lieferadresse) {
    return LieferadresseRestClientRepresentation.builder()
        .name(lieferadresse.getName())
        .strasse(lieferadresse.getStrasse())
        .plz(lieferadresse.getPlz())
        .ort(lieferadresse.getOrt())
        .build();
  }
}
