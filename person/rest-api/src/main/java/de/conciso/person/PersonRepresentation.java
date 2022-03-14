package de.conciso.person;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonRepresentation {

  int id;
  String vorname;
  String name;
  List<AddressRepresentation> addresses;

  public Person toPerson() {
    return new Person(vorname, name);
  }

  public static PersonRepresentation from(Person person) {
    return PersonRepresentation.builder()
        .id(person.getId())
        .vorname(person.getVorname())
        .name(person.getName())
        .addresses(AddressRepresentation.from(person.getAddresses()))
        .build();
  }
}
