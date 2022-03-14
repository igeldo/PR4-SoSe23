package de.conciso.person;

import java.util.Optional;

public interface Personen {
  Person create(Person person);
  Optional<Person> addAddress(int personId, Address address);
  Optional<Person> findById(int id);
}
