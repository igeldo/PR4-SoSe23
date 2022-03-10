package de.conciso.person;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonRepresentation {

    int id;
    String vorname;
    String name;
    List<AddressRepresentation> addresses;

    static PersonRepresentation from(Person person) {
        return PersonRepresentation.builder()
            .id(person.getId())
            .vorname(person.getVorname())
            .name(person.getName())
            .addresses(person.getAddresses().stream()
                .map(AddressRepresentation::from)
                .collect(Collectors.toList())
            )
            .build();
    }
}
