package de.conciso.auftrag;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artikel {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String nummer;
  private String bezeichnung;
  private int anzahl;

  public Artikel() {
  }

  public Artikel(String nummer, String bezeichnung, int anzahl) {
    this.nummer = nummer;
    this.bezeichnung = bezeichnung;
    this.anzahl = anzahl;
  }

  public Artikel(int id, String nummer, String bezeichnung, int anzahl) {
    this.id = id;
    this.nummer = nummer;
    this.bezeichnung = bezeichnung;
    this.anzahl = anzahl;
  }

  public int getId() {
    return id;
  }

  public String getNummer() {
    return nummer;
  }

  public void setNummer(String nummer) {
    this.nummer = nummer;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String berzeichnung) {
    this.bezeichnung = berzeichnung;
  }

  public int getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(int anzahl) {
    this.anzahl = anzahl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Artikel artikel = (Artikel) o;
    return anzahl == artikel.anzahl && Objects.equals(nummer, artikel.nummer) && Objects.equals(bezeichnung, artikel.bezeichnung);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nummer, bezeichnung, anzahl);
  }
}
