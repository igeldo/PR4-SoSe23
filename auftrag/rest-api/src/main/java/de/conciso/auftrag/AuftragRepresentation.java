package de.conciso.auftrag;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuftragRepresentation {

    int id;
    String bestellNummer;

    static AuftragRepresentation from(Auftrag auftrag) {
        return AuftragRepresentation.builder()
            .id(auftrag.getId())
            .bestellNummer(auftrag.getBestellNummer())
            .build();
    }
}
