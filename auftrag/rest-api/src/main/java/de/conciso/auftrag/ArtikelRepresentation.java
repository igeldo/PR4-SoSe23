package de.conciso.auftrag;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ArtikelRepresentation {

    String nummer;
    String bezeichnung;
    int anzahl;

    public static ArtikelRepresentation from(Artikel artikel) {
        return ArtikelRepresentation.builder()
            .nummer(artikel.getNummer())
            .bezeichnung(artikel.getBezeichnung())
            .anzahl(artikel.getAnzahl())
            .build();
    }

    public static List<ArtikelRepresentation> from(List<Artikel> artikel) {
        return artikel.stream()
            .map(ArtikelRepresentation::from)
            .collect(Collectors.toList());
    }

    public Artikel toArtikel() {
        return new Artikel(nummer, bezeichnung, anzahl);
    }
}
