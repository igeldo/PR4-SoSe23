package de.conciso.person;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
  Person save(Person person);
  Optional<Person> findById(int id);
  Optional<Person> findByName(String name);
  Optional<Person> findByVorname(String vorname);
  Optional<Person> deleteById(int id);
  List<Person> findAll();
}
