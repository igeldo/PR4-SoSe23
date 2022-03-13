package de.conciso.shop;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class Auftrag {
  int id;
  String bestellNummer;
  Lieferadresse lieferadresse;
}
