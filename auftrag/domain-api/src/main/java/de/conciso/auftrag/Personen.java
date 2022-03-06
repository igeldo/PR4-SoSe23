package de.conciso.auftrag;

import java.util.Optional;

public interface Personen {
  Person create(String vorname, String name);
  Optional<Person> findById(int id);
}
