package de.conciso.starter;

import lombok.Data;

@Data
public class Bestellung {

  int id;
  Produkt produkt;
  int anzahl;
  Bestellstatus status;
}
