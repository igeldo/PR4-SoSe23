package de.conciso.starter;

import java.util.Optional;

public interface PersonDAO {
  Person save(Person person);
  Optional<Person> findById(int id);
}
