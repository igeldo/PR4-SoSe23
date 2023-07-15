package de.conciso.person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface Personen {
  Person create(Person person);
  Optional<Person> addAddress(int personId, Address address);
  Optional<Person> findById(int id);
  Optional<Person> findByName(String name);
  Optional<Person> findByVorname(String vorname);
  Optional<Person> changeAddress(int personId, Address address, int addressIndex);
  Optional<Person> changeLastAddress(int personId, Address address);
  Optional<Person> changeName(int personId, String name);
  Optional<Person> changeVorname(int personId, String name);
  List<Person> findAll();
  Optional<Person> deleteById(int id);
}
