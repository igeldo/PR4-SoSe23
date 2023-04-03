package de.conciso.shop;

import java.util.Optional;

public interface Auftraege {
  Auftrag create(Auftrag auftrag);
  Optional<Auftrag> findById(int id);
}
