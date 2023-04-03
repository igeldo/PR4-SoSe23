package de.conciso.shop;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class Lieferadresse {
  String name;
  String strasse;
  int plz;
  String ort;
}
