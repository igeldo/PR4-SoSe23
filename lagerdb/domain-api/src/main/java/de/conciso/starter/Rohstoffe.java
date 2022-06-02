package de.conciso.starter;

import java.util.Optional;

public interface Rohstoffe {

  Rohstoff erzeuge(String id, String name, char code, String gebinde);

  Optional<Rohstoff> findById(String id);
}
