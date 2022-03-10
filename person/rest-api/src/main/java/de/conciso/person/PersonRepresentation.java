package de.conciso.person;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonRepresentation {

    int id;
    String vorname;
    String name;

    static PersonRepresentation from(Person person) {
        return PersonRepresentation.builder()
            .id(person.getId())
            .vorname(person.getVorname())
            .name(person.getName())
            .build();
    }
}
