package de.conciso.auftrag;

import java.util.Optional;

public interface Auftraege {
  Auftrag create(Auftrag auftrag);
  Optional<Auftrag> findById(int id);
}
