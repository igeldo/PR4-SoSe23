package de.conciso.shop;

import java.util.Optional;

public interface Shop {
  Person createPerson(Person person);

  Optional<Person> addAddress(int personId, Address address);

  Optional<Person> findPerson(int id);

  Optional<Auftrag> placeOrder(int personId, String bestellNummer);

  Optional<Auftrag> findAuftrag(int id);
}
