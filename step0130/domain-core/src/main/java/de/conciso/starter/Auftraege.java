package de.conciso.starter;

import java.util.Optional;

public interface Auftraege {

  Auftrag create(Auftrag auftrag);
  Optional<Auftrag> find(int id);
}
