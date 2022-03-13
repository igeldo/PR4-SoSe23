package de.conciso.shop;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
  String strasse;
  int plz;
  String ort;
}
