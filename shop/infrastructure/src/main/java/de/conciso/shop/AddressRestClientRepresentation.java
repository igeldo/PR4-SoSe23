package de.conciso.shop;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
public class AddressRestClientRepresentation {

  String strasse;
  int plz;
  String ort;

  public Address toAddress() {
    return Address.builder()
        .strasse(strasse)
        .plz(plz)
        .ort(ort)
        .build();
  }
}
