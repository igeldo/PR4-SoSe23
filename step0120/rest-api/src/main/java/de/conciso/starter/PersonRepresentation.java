package de.conciso.starter;

import org.immutables.value.Value;

@Value.Immutable
public interface PersonRepresentation {

    String getVorname();

    String getName();

    static PersonRepresentation from(Person person) {
        return ImmutablePersonRepresentation.builder()
            .vorname(person.getVorname())
            .name(person.getName())
            .build();
    }
}
