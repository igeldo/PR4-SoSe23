package de.conciso.shop;

import java.util.Optional;

public interface Shop {
  Person createPerson(String vorname, String name);

  Optional<Person> addAddress(int personId, String strasse, int plz, String ort);

  Optional<Person> findPerson(int id);

  Optional<Auftrag> placeOrder(int personId, String bestellNummer);

  Optional<Auftrag> findAuftrag(int id);
}
