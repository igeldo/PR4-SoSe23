package de.conciso.starter;

import java.util.Collection;

import lombok.Data;

@Data
public class Produkt {

  int id;
  String name;
  long preis;
  Collection<Zutat> zutaten;
}
