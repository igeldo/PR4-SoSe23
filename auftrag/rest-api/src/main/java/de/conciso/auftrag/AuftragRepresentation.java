package de.conciso.auftrag;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuftragRepresentation {

    int id;
    String bestellNummer;
    LieferadresseRepresentation lieferadresse;
    List<ArtikelRepresentation> artikel;

    static AuftragRepresentation from(Auftrag auftrag) {
        return AuftragRepresentation.builder()
            .id(auftrag.getId())
            .bestellNummer(auftrag.getBestellNummer())
            .lieferadresse(LieferadresseRepresentation.from(new Lieferadresse()))
            .artikel(ArtikelRepresentation.from(auftrag.getArtikel()))
            .build();
    }
}
