package de.conciso.shop;

import java.util.List;
import java.util.stream.Collectors;

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

  public static AddressRestClientRepresentation from(Address address) {
    return AddressRestClientRepresentation.builder()
        .strasse(address.getStrasse())
        .plz(address.getPlz())
        .ort(address.getOrt())
        .build();
  }
}
