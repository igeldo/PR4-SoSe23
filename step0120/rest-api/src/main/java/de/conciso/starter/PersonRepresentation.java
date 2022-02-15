package de.conciso.starter;

import lombok.Value;

@Value
public class PersonRepresentation {

    private String vorname;

    private String name;

    static PersonRepresentation from(Person person) {
        return new PersonRepresentation(person.getVorname(), person.getName());
    }
}
