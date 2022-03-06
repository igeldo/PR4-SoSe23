package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Auftrag {
  private String bestellNummer;
}
