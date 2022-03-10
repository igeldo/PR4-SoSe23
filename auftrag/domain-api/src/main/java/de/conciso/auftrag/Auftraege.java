package de.conciso.auftrag;

import java.util.Optional;

public interface Auftraege {
  Auftrag create(String bestellNummer);
  Optional<Auftrag> findById(int id);
}
