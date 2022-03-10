package de.conciso.person;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String strasse;
  private int plz;
  private String ort;

  public Address() {
  }

  public Address(String strasse, int plz, String ort) {
    this.strasse = strasse;
    this.plz = plz;
    this.ort = ort;
  }

  public Address(int id, String strasse, int plz, String ort) {
    this.id = id;
    this.strasse = strasse;
    this.plz = plz;
    this.ort = ort;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    Address address = (Address) o;
    return id == address.id && plz == address.plz && Objects.equals(strasse, address.strasse) && Objects.equals(ort, address.ort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, strasse, plz, ort);
  }
}
