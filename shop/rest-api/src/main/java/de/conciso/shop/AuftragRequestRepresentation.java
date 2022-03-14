package de.conciso.shop;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuftragRequestRepresentation {
  int personId;
  String bestellNummer;
}
