package de.conciso.starter;

import java.util.Collection;
import java.util.Optional;

public interface Produkte {

  Produkt erzeuge(String id, String name, long preis, Collection<Zutat> zutaten);

  Optional<Produkt> findById(String id);
}
