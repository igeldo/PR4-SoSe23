package de.conciso.person;

import java.util.Optional;

public interface PersonDAO {
  Person save(Person person);
  Optional<Person> findById(int id);
}
