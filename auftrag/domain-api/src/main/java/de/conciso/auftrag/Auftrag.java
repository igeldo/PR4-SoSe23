package de.conciso.auftrag;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auftrag {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String bestellNummer;

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

  public void setId(int id) {
    this.id = id;
  }

  public String getBestellNummer() {
    return bestellNummer;
  }

  public void setBestellNummer(String bestellNummer) {
    this.bestellNummer = bestellNummer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Auftrag auftrag = (Auftrag) o;
    return id == auftrag.id && Objects.equals(bestellNummer, auftrag.bestellNummer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bestellNummer);
  }
}
