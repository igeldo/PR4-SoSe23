package de.conciso.auftrag;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuftragRepresentation {

  String bestellNummer;
  LieferadresseRepresentation lieferadresse;
  List<ArtikelRepresentation> artikel;

  static AuftragRepresentation from(Auftrag auftrag) {
    return AuftragRepresentation.builder()
        .bestellNummer(auftrag.getBestellNummer())
        .lieferadresse(LieferadresseRepresentation.from(auftrag.getLieferadresse()))
        .artikel(ArtikelRepresentation.from(auftrag.getArtikel()))
        .build();
  }

  public Auftrag toAuftrag() {
    var auftrag = new Auftrag(bestellNummer);
    if (lieferadresse != null) {
      auftrag.setLieferadresse(lieferadresse.toLieferadresse());
    }
    if (artikel != null) {
      artikel.forEach(a -> auftrag.addArtikel(a.toArtikel()));
    }
    return auftrag;
  }
}
