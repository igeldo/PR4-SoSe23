package de.conciso.shop;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
public class PersonRestClientRepresentation {

  int id;
  String vorname;
  String name;
  List<AddressRestClientRepresentation> addresses;

  public Person toPerson() {
    return Person.builder()
        .id(id)
        .vorname(vorname)
        .name(name)
        .adresses(addresses.stream()
            .map(AddressRestClientRepresentation::toAddress)
            .collect(Collectors.toList())
        )
        .build();
  }

  public static PersonRestClientRepresentation from(Person person) {
    return PersonRestClientRepresentation.builder()
        .vorname(person.getVorname())
        .name(person.getName())
        .build();
  }
}
