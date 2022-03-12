package de.conciso.auftrag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Auftrag {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String bestellNummer;

  @OneToOne(cascade = CascadeType.ALL)
  private Lieferadresse lieferadresse;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "auftragId", referencedColumnName = "id")
  private List<Artikel> artikel = new ArrayList<>();

  public Auftrag() {
  }

  public Auftrag(String bestellNummer) {
    this.bestellNummer = bestellNummer;
  }

  public Auftrag(int id, String bestellNummer) {
    this.id = id;
    this.bestellNummer = bestellNummer;
  }

  public int getId() {
    return id;
  }

  public String getBestellNummer() {
    return bestellNummer;
  }

  public void setBestellNummer(String bestellNummer) {
    this.bestellNummer = bestellNummer;
  }

  public Lieferadresse getLieferadresse() {
    return lieferadresse;
  }

  public void setLieferadresse(Lieferadresse lieferadresse) {
    this.lieferadresse = lieferadresse;
  }

  public List<Artikel> getArtikel() {
    return Collections.unmodifiableList(artikel);
  }

  public void addArtikel(Artikel artikel) {
    this.artikel.add(artikel);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Auftrag auftrag = (Auftrag) o;
    return Objects.equals(bestellNummer, auftrag.bestellNummer) && Objects.equals(lieferadresse, auftrag.lieferadresse) && Objects.equals(artikel, auftrag.artikel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bestellNummer, lieferadresse, artikel);
  }
}
