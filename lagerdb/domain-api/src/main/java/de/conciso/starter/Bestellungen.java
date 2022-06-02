package de.conciso.starter;

import java.util.Optional;

public interface Bestellungen {

  Bestellung bestelle(String kunde, int produktId, int anzahl);

  Optional<Bestellung> findById(String id);
}
