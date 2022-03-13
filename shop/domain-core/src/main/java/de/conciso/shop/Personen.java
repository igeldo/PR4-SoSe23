package de.conciso.shop;

import java.util.Optional;

public interface Personen {
  Person create(Person person);
  Optional<Person> addAddress(int personId, String strasse, int plz, String ort);
  Optional<Person> findById(int id);
}
