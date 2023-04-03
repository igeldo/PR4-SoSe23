package de.conciso.auftrag;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lieferadresse {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  private String name;
  private String strasse;
  private int plz;
  private String ort;

  public Lieferadresse() {
  }

  public Lieferadresse(String name, String strasse, int plz, String ort) {
    this.name = name;
    this.strasse = strasse;
    this.plz = plz;
    this.ort = ort;
  }

  public Lieferadresse(int id, String name, String strasse, int plz, String ort) {
    this.id = id;
    this.name = name;
    this.strasse = strasse;
    this.plz = plz;
    this.ort = ort;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public int getPlz() {
    return plz;
  }

  public void setPlz(int plz) {
    this.plz = plz;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lieferadresse that = (Lieferadresse) o;
    return plz == that.plz && Objects.equals(name, that.name) && Objects.equals(strasse, that.strasse) && Objects.equals(ort, that.ort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, strasse, plz, ort);
  }
}
